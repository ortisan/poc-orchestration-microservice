provider "aws" {
  region = "us-east-1"
}

### VARIABLES

variable "cluster_name" {
  default = "poc_orchestrator_cluster"
  type    = string
}

variable "cluster_version" {
  default = "1.19"
  type    = string
}

### PRIVATE NETWORK (https://aws.amazon.com/pt/blogs/containers/upcoming-changes-to-ip-assignment-for-eks-managed-node-groups/ AND https://docs.aws.amazon.com/eks/latest/userguide/create-public-private-vpc.html)

resource "aws_vpc" "vpc_eks" {
  cidr_block           = "192.168.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true
  tags = {
    Name = "vpc_eks"
  }
}

resource "aws_route_table" "private_route_table_vpc_eks" {
  vpc_id = aws_vpc.vpc_eks.id
  tags = {
    Name = "private_route_table_vpc_eks"
  }
}

resource "aws_subnet" "subnet_eks_1a" {
  vpc_id                  = aws_vpc.vpc_eks.id
  cidr_block              = "192.168.0.0/18"
  availability_zone       = "us-east-1a"
  map_public_ip_on_launch = false
  tags = {
    "Name"                            = "subnet_eks_1a"
    "kubernetes.io/role/internal-elb" = "1"
  }
}

resource "aws_subnet" "subnet_eks_1b" {
  vpc_id                  = aws_vpc.vpc_eks.id
  cidr_block              = "192.168.64.0/18"
  availability_zone       = "us-east-1b"
  map_public_ip_on_launch = false

  tags = {
    "Name"                            = "subnet_eks_1b"
    "kubernetes.io/role/internal-elb" = "1"
  }
}

resource "aws_route_table_association" "private_subnet_1a_rt_assoc" {
  subnet_id      = aws_subnet.subnet_eks_1a.id
  route_table_id = aws_route_table.private_route_table_vpc_eks.id
}

resource "aws_route_table_association" "private_subnet_1b_rt_assoc" {
  subnet_id      = aws_subnet.subnet_eks_1b.id
  route_table_id = aws_route_table.private_route_table_vpc_eks.id
}


resource "aws_security_group" "endpoint-security-group" {
  name        = "terraform-eks-demo-cluster"
  description = "Cluster communication with worker nodes"
  vpc_id      = aws_vpc.vpc_eks.id

  ingress {
    description = "Security group to govern who can access the endpoints"
    from_port   = 443
    to_port     = 443
    protocol    = "tcp"
    cidr_blocks = [aws_vpc.vpc_eks.cidr_block]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "security_group_endpoints"
  }
}

resource "aws_vpc_endpoint" "s3_endpoint" {
  service_name      = "com.amazonaws.us-east-1.s3"
  vpc_endpoint_type = "Gateway"
  route_table_ids   = [aws_route_table.private_route_table_vpc_eks.id]
  vpc_id            = aws_vpc.vpc_eks.id
}

resource "aws_vpc_endpoint" "ecr_endpoint" {
  service_name        = "com.amazonaws.us-east-1.ecr.api"
  vpc_endpoint_type   = "Interface"
  private_dns_enabled = true
  security_group_ids  = [aws_security_group.endpoint-security-group.id]
  subnet_ids          = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  vpc_id              = aws_vpc.vpc_eks.id
}

resource "aws_vpc_endpoint" "ecr_dkr_endpoint" {
  service_name        = "com.amazonaws.us-east-1.ecr.dkr"
  vpc_endpoint_type   = "Interface"
  private_dns_enabled = true
  security_group_ids  = [aws_security_group.endpoint-security-group.id]
  subnet_ids          = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  vpc_id              = aws_vpc.vpc_eks.id
}

resource "aws_vpc_endpoint" "ec2_endpoint" {
  service_name        = "com.amazonaws.us-east-1.ec2"
  vpc_endpoint_type   = "Interface"
  private_dns_enabled = true
  security_group_ids  = [aws_security_group.endpoint-security-group.id]
  subnet_ids          = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  vpc_id              = aws_vpc.vpc_eks.id
}

resource "aws_vpc_endpoint" "logs_endpoint" {
  service_name        = "com.amazonaws.us-east-1.logs"
  vpc_endpoint_type   = "Interface"
  private_dns_enabled = true
  security_group_ids  = [aws_security_group.endpoint-security-group.id]
  subnet_ids          = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  vpc_id              = aws_vpc.vpc_eks.id
}

resource "aws_vpc_endpoint" "sts_endpoint" {
  service_name        = "com.amazonaws.us-east-1.sts"
  vpc_endpoint_type   = "Interface"
  private_dns_enabled = true
  security_group_ids  = [aws_security_group.endpoint-security-group.id]
  subnet_ids          = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  vpc_id              = aws_vpc.vpc_eks.id
}


### CLUSTER


resource "aws_iam_role" "service_role_eks_cluster" {
  name = "service_role_eks_cluster"

  assume_role_policy = <<POLICY
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Service": "eks.amazonaws.com"
      },
      "Action": "sts:AssumeRole"
    }
  ]
}
POLICY
}

resource "aws_iam_role_policy_attachment" "service_role_eks_cluster-AmazonEKSClusterPolicy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
  role       = aws_iam_role.service_role_eks_cluster.name
}

resource "aws_iam_role_policy_attachment" "service_role_eks_cluster-AmazonEKSVPCResourceController" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSVPCResourceController"
  role       = aws_iam_role.service_role_eks_cluster.name
}

resource "aws_cloudwatch_log_group" "cluster_log_group" {
  # The log group name format is /aws/eks/<cluster-name>/cluster
  # Reference: https://docs.aws.amazon.com/eks/latest/userguide/control-plane-logs.html
  name              = "/aws/eks/${var.cluster_name}/cluster"
  retention_in_days = 7
}

resource "aws_security_group" "eks_security_group" {
  name        = "eks_security_group"
  description = "Cluster communication with worker nodes"
  vpc_id      = aws_vpc.vpc_eks.id

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "eks_security_group"
  }
}

resource "aws_eks_cluster" "eks_cluster" {
  enabled_cluster_log_types = ["api", "audit"]
  name                      = var.cluster_name
  version                   = var.cluster_version
  role_arn                  = aws_iam_role.service_role_eks_cluster.arn

  vpc_config {
    endpoint_private_access = true
    endpoint_public_access  = false
    subnet_ids              = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]
  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Cluster handling.
  # Otherwise, EKS will not be able to properly delete EKS managed EC2 infrastructure such as Security Groups.
  depends_on = [
    aws_iam_role_policy_attachment.service_role_eks_cluster-AmazonEKSClusterPolicy,
    aws_iam_role_policy_attachment.service_role_eks_cluster-AmazonEKSVPCResourceController,
    aws_cloudwatch_log_group.cluster_log_group,
  ]
}

### CLUSTER NODEGROUP

resource "aws_iam_role" "service_role_node_group_eks_cluster" {
  name = "service_role_node_group_eks_cluster"

  assume_role_policy = jsonencode({
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = {
        Service = "ec2.amazonaws.com"
      }
    }]
    Version = "2012-10-17"
  })
}

resource "aws_iam_role_policy_attachment" "service_role_node_group_eks_cluster-AmazonEKSWorkerNodePolicy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSWorkerNodePolicy"
  role       = aws_iam_role.service_role_node_group_eks_cluster.name
}

resource "aws_iam_role_policy_attachment" "service_role_node_group_eks_cluster-AmazonEKS_CNI_Policy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKS_CNI_Policy"
  role       = aws_iam_role.service_role_node_group_eks_cluster.name
}

resource "aws_iam_role_policy_attachment" "service_role_node_group_eks_cluster-AmazonEC2ContainerRegistryReadOnly" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
  role       = aws_iam_role.service_role_node_group_eks_cluster.name
}

resource "aws_eks_node_group" "poc_node_group" {
  cluster_name    = aws_eks_cluster.eks_cluster.name
  node_group_name = "poc_node_group"
  node_role_arn   = aws_iam_role.service_role_node_group_eks_cluster.arn
  subnet_ids      = [aws_subnet.subnet_eks_1a.id, aws_subnet.subnet_eks_1b.id]

  scaling_config {
    desired_size = 1
    max_size     = 1
    min_size     = 1

  }

  # Ensure that IAM Role permissions are created before and deleted after EKS Node Group handling.
  # Otherwise, EKS will not be able to properly delete EC2 Instances and Elastic Network Interfaces.
  depends_on = [
    aws_iam_role_policy_attachment.service_role_node_group_eks_cluster-AmazonEKSWorkerNodePolicy,
    aws_iam_role_policy_attachment.service_role_node_group_eks_cluster-AmazonEKS_CNI_Policy,
    aws_iam_role_policy_attachment.service_role_node_group_eks_cluster-AmazonEC2ContainerRegistryReadOnly,
  ]
}

### OUTPUTS

output "endpoint" {
  value = aws_eks_cluster.eks_cluster.endpoint
}

output "kubeconfig-certificate-authority-data" {
  value = aws_eks_cluster.eks_cluster.certificate_authority[0].data
}