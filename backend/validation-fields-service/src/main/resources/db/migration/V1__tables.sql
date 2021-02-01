CREATE TABLE field (name VARCHAR(255));
ALTER TABLE field
ADD CONSTRAINT pk_field PRIMARY KEY(name);
CREATE TABLE verified_field(
  id MEDIUMINT NOT NULL AUTO_INCREMENT,
  created_date TIMESTAMP NOT NULL,
  person_id VARCHAR(255) NOT NULL,
  tenant_id VARCHAR(255) NOT NULL,
  level INTEGER,
  validated BOOLEAN,
  value VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY(id)
);
ALTER TABLE verified_field
ADD CONSTRAINT fk_field_verified_field_entity FOREIGN KEY(name) REFERENCES field(name);