CREATE TABLE `phone` (
  `id` varchar(255) NOT NULL,
  `ddd` int DEFAULT NULL,
  `ddi` int DEFAULT NULL,
  `extension_line` int DEFAULT NULL,
  `number` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person_identity` (
  `id` varchar(255) NOT NULL,
  `country_code` varchar(255) DEFAULT NULL,
  `document_number` varchar(255) DEFAULT NULL,
  `document_type` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person` (
  `dtype` varchar(31) NOT NULL,
  `person_id` varchar(255) NOT NULL,
  `tenant_id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `person_phones` (
  `person_person_id` varchar(255) NOT NULL,
  `person_tenant_id` varchar(255) NOT NULL,
  `phones_id` varchar(255) NOT NULL,
  UNIQUE KEY `UK_haq8fex9okoi3kpaxmqe1kpcl` (`phones_id`),
  KEY `FK1ui5q3f9booah0nqppxu6muxl` (`person_person_id`,`person_tenant_id`),
  CONSTRAINT `FK1ui5q3f9booah0nqppxu6muxl` FOREIGN KEY (`person_person_id`, `person_tenant_id`) REFERENCES `person` (`person_id`, `tenant_id`),
  CONSTRAINT `FKincp66whfw4olpi3osmd8mylw` FOREIGN KEY (`phones_id`) REFERENCES `phone` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

