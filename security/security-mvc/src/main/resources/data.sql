DROP TABLE IF EXISTS role_sec;
DROP TABLE IF EXISTS USER_SEC;
DROP TABLE IF EXISTS user_demographic_sec;
DROP TABLE IF EXISTS user_role_sec;

CREATE TABLE user_demographic_sec (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  contact VARCHAR(250) DEFAULT NULL,
  user_uid INT
);

CREATE TABLE role_sec (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE user_role_sec (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  role_id INT NOT NULL,
  user_id INT NOT NULL
);

CREATE TABLE USER_SEC (
  uid INT AUTO_INCREMENT  PRIMARY KEY,
  account_non_expired BOOLEAN NOT NULL,
  account_non_locked BOOLEAN NOT NULL,
  credentials_non_expired BOOLEAN NOT NULL,
  enable BOOLEAN NOT NULL,
  password VARCHAR(250) NOT NULL,
  username VARCHAR(250) NOT NULL
);

ALTER TABLE user_demographic_sec
    ADD FOREIGN KEY (user_uid)
    REFERENCES USER_SEC(uid);

ALTER TABLE user_role_sec
    ADD FOREIGN KEY (user_id)
    REFERENCES USER_SEC(uid);

ALTER TABLE user_role_sec
    ADD FOREIGN KEY (role_id)
    REFERENCES role_sec(id);


INSERT INTO role_sec (name) VALUES
  ('emp_read'),
  ('emp_write'),
  ('emp_update'),
      ('admin_usr_create'),
  ('admin_user_view'),
  ('admin_user_edit'),
  ('emp_empty_role');
  ;

INSERT INTO USER_SEC (uid,account_non_expired, account_non_locked, credentials_non_expired, enable,password, username ) VALUES
  (10000,TRUE, TRUE, TRUE , TRUE, 'password', 'user1'),
  (10001,TRUE, TRUE, TRUE , TRUE, 'password', 'user2');


INSERT INTO user_role_sec (id,role_id,user_id) VALUES
  (1,2,10001),
  (2,1,10001),
  (3,3,10000);

INSERT INTO user_demographic_sec (id,first_name, last_name, contact, user_uid) VALUES
  (10000,'Aliko', 'Dangote', '9970440296' , 10000),
  (10001,'Bill', 'Gates', '327983982',10001);
