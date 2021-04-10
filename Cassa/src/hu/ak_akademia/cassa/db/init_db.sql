CREATE SEQUENCE cassa_seq;
CREATE SEQUENCE entry_seq;

CREATE TABLE cassa (
    cassa_id NUMERIC(20) NOT NULL,
    cassa_name VARCHAR(30) NOT NULL,
    cassa_limit NUMERIC(20) NOT NULL,
    last_edit TIMESTAMP NOT NULL,
    CONSTRAINT cassa_pk PRIMARY KEY (cassa_id)
);
 
CREATE TABLE entry (
    entry_id NUMERIC(20) NOT NULL,
    cassa_id NUMERIC(20) NOT NULL,
    entry_name VARCHAR(30) NOT NULL,
    amount NUMERIC(20) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    CONSTRAINT entry_pk PRIMARY KEY (entry_id),
    CONSTRAINT entry_fk1 FOREIGN KEY (cassa_id) REFERENCES cassa(cassa_id)
);
 
INSERT INTO cassa (cassa_id, cassa_name, cassa_limit, last_edit) VALUES (NEXTVAL('cassa_seq'), 'My Cassa', '1000000', NOW());
INSERT INTO entry (entry_id, cassa_id, entry_name, amount, creation_date) VALUES (NEXTVAL('entry_seq'), 1, 'bevétel', 1000, NOW());
INSERT INTO entry (entry_id, cassa_id, entry_name, amount, creation_date) VALUES (NEXTVAL('entry_seq'), 1, 'készpénzes bevétel', 2000, NOW());