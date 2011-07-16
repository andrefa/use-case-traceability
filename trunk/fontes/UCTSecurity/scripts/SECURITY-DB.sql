------------------------------------------------------------------------------------
------------------------------------ PASSWORD --------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE password(id   INTEGER  PRIMARY KEY,                                 
                      password VARCHAR NOT NULL);                                    
                                                                                  
CREATE SEQUENCE s_password_01 AS INTEGER START WITH 1 INCREMENT BY 1;
------------------------------------------------------------------------------------
------------------------------------ KEY -------------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE key(id   INTEGER  PRIMARY KEY,                                 
                 key VARCHAR NOT NULL);                                    
                                                                                  
CREATE SEQUENCE s_key_01 AS INTEGER START WITH 1 INCREMENT BY 1;
------------------------------------------------------------------------------------
------------------------------------ USER ------------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE user(login VARCHAR  PRIMARY KEY,                                 
                  name VARCHAR NOT NULL,
		  password_id INTEGER NOT NULL,
		  key_id INTEGER NOT NULL);                                    

ALTER TABLE user
ADD CONSTRAINT user_password_fk_01 
FOREIGN KEY(password_id)
REFERENCES password(id); 

ALTER TABLE user
ADD CONSTRAINT user_key_fk_01 
FOREIGN KEY(key_id)
REFERENCES key(id);
------------------------------------------------------------------------------------
------------------------------------ GROUP -----------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE group_table(id VARCHAR  PRIMARY KEY,                                 
                         name VARCHAR NOT NULL,
		         description VARCHAR NOT NULL,
		         key_id INTEGER NOT NULL,
		         user_login VARCHAR NOT NULL);                                    

ALTER TABLE group_table
ADD CONSTRAINT grouptable_key_fk_01 
FOREIGN KEY(key_id)
REFERENCES key(id); 

ALTER TABLE group_table
ADD CONSTRAINT grouptable_user_fk_01 
FOREIGN KEY(user_login)
REFERENCES user(login);
------------------------------------------------------------------------------------
------------------------------------ FUNCTIONALITY ---------------------------------
------------------------------------------------------------------------------------
CREATE TABLE functionality(id VARCHAR  PRIMARY KEY,
		           description VARCHAR NOT NULL,
		           key_id INTEGER NOT NULL,
		           group_id VARCHAR NOT NULL);                                    

ALTER TABLE functionality
ADD CONSTRAINT functionality_key_fk_01 
FOREIGN KEY(key_id)
REFERENCES key(id); 

ALTER TABLE functionality
ADD CONSTRAINT functionality_group_fk_01 
FOREIGN KEY(group_id)
REFERENCES group_table(id);
------------------------------------------------------------------------------------
------------------------------------ AUDITING --------------------------------------
------------------------------------------------------------------------------------
CREATE TABLE auditing(id   INTEGER  PRIMARY KEY,                                 
                      description VARCHAR NOT NULL,
                      user_login VARCHAR NOT NULL,
                      sysdate TIMESTAMP NOT NULL);                                    
                                                                                  
CREATE SEQUENCE s_auditing_01 AS INTEGER START WITH 1 INCREMENT BY 1; 

ALTER TABLE auditing
ADD CONSTRAINT auditing_user_fk_01 
FOREIGN KEY(user_login)
REFERENCES user(login);
------------------------------------------------------------------------------------
--********************************************************************************--
--********************************************************************************--
------------------------------------------------------------------------------------
--------------------------------- DROP ALL TABLES ----------------------------------
------------------------------------------------------------------------------------
drop sequence s_password_01;
drop sequence s_key_01;
drop sequence s_auditing_01;
drop table auditing;
drop table functionality;
drop table group_table;
drop table user;
drop table key;
drop table password;
------------------------------------------------------------------------------------
