------------------------------------------------------------------------------------
------------------------------------ PROJECT ---------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE project(id   INTEGER  PRIMARY KEY,                                 
                      name VARCHAR NOT NULL,
                      path_project VARCHAR NOT NULL);                                    
                                                                                  
CREATE SEQUENCE s_project_01 AS INTEGER START WITH 1 INCREMENT BY 1;          
------------------------------------------------------------------------------------
----------------------------- FUNCTIONAL_REQUISITE ---------------------------------
------------------------------------------------------------------------------------
CREATE TABLE functional_requisite(id VARCHAR NOT NULL,
                                   name VARCHAR NOT NULL,
                                   description VARCHAR NOT NULL, 
                                   project_id INTEGER NOT NULL);

ALTER TABLE functional_requisite
ADD CONSTRAINT functionalrequisite_project_fk_01 
FOREIGN KEY(project_id)
REFERENCES project(id);

ALTER TABLE functional_requisite
ADD CONSTRAINT functionalrequisite_uk_01
UNIQUE(id, project_id);
------------------------------------------------------------------------------------
------------------------------------ USE_CASE --------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE use_case(id VARCHAR NOT NULL,
                       name VARCHAR NOT NULL, 
                       description VARCHAR NOT NULL, 
                       project_id INTEGER NOT NULL);

ALTER TABLE use_case
ADD CONSTRAINT usecase_project_fk_01 
FOREIGN KEY(project_id)
REFERENCES project(id);

ALTER TABLE use_case
ADD CONSTRAINT usecase_uk_01
UNIQUE(id, project_id);
------------------------------------------------------------------------------------
-------------------------- IMPLEMENTATION_RULE -------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE implementation_rule(id VARCHAR PRIMARY KEY,
                                  name VARCHAR NOT NULL, 
                                  description VARCHAR NOT NULL,
                                  project_id INTEGER NOT NULL);

ALTER TABLE implementation_rule
ADD CONSTRAINT implementationrule_project_fk_01 
FOREIGN KEY(project_id)
REFERENCES project(id);

ALTER TABLE implementation_rule
ADD CONSTRAINT implementationrule_uk_01
UNIQUE(id, project_id);
------------------------------------------------------------------------------------
--------------------------------- BUSINESS_RULE ------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE business_rule(id VARCHAR PRIMARY KEY,
                            name VARCHAR NOT NULL, 
                            description VARCHAR NOT NULL,
                            project_id INTEGER NOT NULL);

ALTER TABLE business_rule
ADD CONSTRAINT businessrule_project_fk_01 
FOREIGN KEY(project_id)
REFERENCES project(id);

ALTER TABLE business_rule
ADD CONSTRAINT businessrule_uk_01
UNIQUE(id, project_id);
------------------------------------------------------------------------------------
--********************************************************************************--
--********************************************************************************--
------------------------------------------------------------------------------------
--------------------------------- DROP ALL TABLES ----------------------------------
------------------------------------------------------------------------------------
drop sequence s_project_01;
drop table business_rule;
drop table implementation_rule;
drop table use_case;
drop table functional_requisite;
drop table project;
------------------------------------------------------------------------------------
