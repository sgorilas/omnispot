ALTER TABLE PENDING DROP CONSTRAINT FK_PENDING_DEPLOYMENT;
ALTER TABLE PENDING DROP CONSTRAINT FK_PENDING_RESOURCE;
DROP TABLE DEPLOYMENT;
DROP TABLE RESOURCE;
DROP TABLE PENDING;