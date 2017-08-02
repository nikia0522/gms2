CREATE SEQUENCE article_seq
 START WITH     1000
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE Member(
	id VARCHAR2(10), 
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	PRIMARY KEY(id)
);

ALTER TABLE Member ADD phone VARCHAR2(13);
ALTER TABLE Member ADD email VARCHAR2(30);

ALTER TABLE Member ADD major_id VARCHAR2(10);
ALTER TABLE Member
ADD CONSTRAINT member_fk_major
FOREIGN KEY (major_id)
REFERENCES Major (major_id);

SELECT * FROM Member; --dml
DROP TABLE Member; --dcl

SELECT * FROM Board;
CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	hitcount NUMBER,
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id)
		ON DELETE CASCADE
);

SELECT * FROM tab;

SELECT * FROM Major;
CREATE TABLE Major(
	major_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(major_id)
	);

SELECT * FROM Subject;
CREATE TABLE Subject(
	subj_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(subj_id)
);

SELECT * FROM student;
CREATE TABLE Student(
	member_id VARCHAR2(10),
	stu_no VARCHAR2(8),
	PRIMARY KEY(member_id),	
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);

SELECT * FROM Prof;
CREATE TABLE Prof(
	member_id VARCHAR2(10),
	salary VARCHAR2(10),
	PRIMARY KEY(member_id),	
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);

ALTER TABLE Subject ADD major_id VARCHAR2(10);
ALTER TABLE Subject
ADD CONSTRAINT Subject_fk_Major
FOREIGN KEY(major_id)
REFERENCES Major (major_id);


SELECT * FROM Grade;
CREATE TABLE Grade(
	grade_seq NUMBER,
	score VARCHAR2(10),
	exam_date VARCHAR2(10),
	PRIMARY KEY(grade_seq)
);

ALTER TABLE Grade ADD subj_id VARCHAR2(10);
ALTER TABLE Grade
ADD CONSTRAINT Grade_fk_Subject
FOREIGN KEY (subj_id)
REFERENCES Subject (subj_id);

ALTER TABLE Grade ADD id VARCHAR2(10);
ALTER TABLE Grade
ADD CONSTRAINT Grade_fk_Member
FOREIGN KEY (id)
REFERENCES Member (id);



ALTER TABLE MEMBER
RENAME COLUMN id TO member_id;
ALTER TABLE Board
RENAME COLUMN id TO member_id;
ALTER TABLE Grade
RENAME COLUMN id TO member_id;