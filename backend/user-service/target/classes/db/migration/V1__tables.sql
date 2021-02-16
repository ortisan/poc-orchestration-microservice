CREATE TABLE phone (
  id varchar(255) NOT NULL,
  ddd int DEFAULT NULL,
  ddi int DEFAULT NULL,
  extension_line int DEFAULT NULL,
  number int DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE person_identity (
  id varchar(255) NOT NULL,
  country_code varchar(255) DEFAULT NULL,
  document_number varchar(255) DEFAULT NULL,
  document_type int DEFAULT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE person_identity ADD CONSTRAINT uc_person_identity UNIQUE (country_code, document_number, document_type);

CREATE TABLE person (
  dtype varchar(31) NOT NULL,
  person_id varchar(255) NOT NULL,
  tenant_id varchar(255) NOT NULL,
  name varchar(255) DEFAULT NULL,
  type varchar(255) DEFAULT NULL,
  cnpj varchar(255) DEFAULT NULL,
  cpf varchar(255) DEFAULT NULL,
  PRIMARY KEY (person_id,tenant_id)
);

CREATE TABLE person_phones (
  person_person_id varchar(255) NOT NULL,
  person_tenant_id varchar(255) NOT NULL,
  phones_id varchar(255) NOT NULL,
  UNIQUE KEY uc_phones_id (phones_id),
  KEY idx_person_phone (person_person_id,person_tenant_id),
  CONSTRAINT fk_person FOREIGN KEY (person_person_id, person_tenant_id) REFERENCES person (person_id, tenant_id),
  CONSTRAINT fk_phone FOREIGN KEY (phones_id) REFERENCES phone (id)
);

