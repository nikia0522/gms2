
SELECT * FROM Board;
SELECT * FROM Grade;
SELECT * FROM Major;
SELECT * FROM Member;
SELECT * FROM Prof;
SELECT * FROM Subject;
SELECT * FROM Student;


-- *******************
-- CREATE 순서
-- 2017.08.02
-- [1] major_tab
-- [2] subject_tab
-- [3] member_tab
-- [4] prof_tab
-- [5] student_tab
-- [6] grade_tab
-- [7] board_tab
-- *******************

DROP SEQUENCE article_seq;

CREATE SEQUENCE seq
START WITH 2000
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- *******************
-- [1] MAJOR TABLE
-- 2017.08.02
-- article_seq, id, title,
-- content, hitcount, regdate
-- *******************
--DDL
CREATE TABLE Major(
	major_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(major_id)
	);
--DML
INSERT INTO Subject(subj_id, title, major_id) VALUES('','','')
	


-- *******************
-- [2] SUBJECT TABLE
-- 2017.08.02
-- 회원관리 테이블
-- subj_id, title
-- *******************
--DDL
CREATE TABLE Subject(
	subj_id VARCHAR2(10),
	title VARCHAR2(10),
	PRIMARY KEY(major_id)
	);
--DML
INSERT INTO Subject(subj_id,title) VALUES ('java','자바');


-- *******************
-- MEMBER TABLE
-- 2017.08.02
-- 회원관리 테이블
-- member_id, name, password, ssn, regdate, major_id, phone, email, profile
-- *******************
CREATE TABLE Member(
	member_id VARCHAR2(10), 
	name VARCHAR2(10),
	password VARCHAR2(10),
	ssn VARCHAR2(15),
	regdate DATE,
	major_id VARCHAR2(10),
	phone VARCHAR2(20),
	email VARCHAR2(20),
	profile VARCHAR2(20),
	PRIMARY KEY(member_id),
	FOREIGN KEY(major_id) REFERENCES Major(major_id)
		ON DELETE CASCADE
);
ALTER TABLE Member
DROP CONSTRAINT member_fk_major
ALTER TABLE Member ADD profile VARCHAR2(30);
ALTER TABLE Member
ADD CONSTRAINT member_fk_Major
FOREIGN KEY(major_id)
REFERENCES Major (major_id);
DROP TABLE MEMBER;
-- DML
INSERT INTO Member(member_id, name, password, ssn, regdate, phone, email, major_id, profile) VALUES ('lees', '이순신', '1', '800331-1234567', SYSDATE, '010-1234-5678','lees@test.com','economics', 'defaultimg.jpg');
SELECT * FROM Member;
SELECT COUNT(*) AS COUNT FROM MEMBER;
UPDATE Member SET phone='' WHERE id='';
DELETE FROM Member WHERE member_id-'';




-- *******************
-- PROF TABLE
-- 2017.08.02
-- 회원관리 테이블
-- member_id, salary
-- *******************
--ddl
CREATE TABLE Prof(
	member_id VARCHAR2(10),
	salary VARCHAR2(10),
	PRIMARY KEY(member_id),	
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);
--dml
INSERT INTO prof(MEMBER_ID, salary) VALUES ('ahn','8000');



-- *******************
-- STUDENT TABLE
-- 2017.08.02
-- 학생정보 테이블
-- member_id, stu_no
-- *******************
--ddl
CREATE TABLE Student(
	member_id VARCHAR2(10),
	stu_no VARCHAR2(8),
	PRIMARY KEY(member_id),	
	FOREIGN KEY(member_id) REFERENCES Member(member_id)
		ON DELETE CASCADE
);
--dml
INSERT INTO STUDENT(MEMBER_ID, STU_NO) VALUES ('gosling','20166002');



-- *******************
-- GRADE TABLE
-- 2017.08.02
-- 성적 테이블
-- member_id, name, password, ssn, regdate, major_id, phone, email, profile
-- *******************
--ddl
SELECT * FROM Grade;
CREATE TABLE Grade(
	grade_seq NUMBER,
	score VARCHAR2(3),
	exam_date VARCHAR2(12),
	subj_id VARCHAR2(10),
	member_id VARCHAR2(10),
	PRIMARY KEY(grade_seq),
	FOREIGN KEY(subj_id) REFERENCES SUBJECT(subj_id) ON DELETE CASCADE,
	FOREIGN KEY(member_id) REFERENCES Member(member_id) ON DELETE CASCADE);
);
ALTER TABLE Grade ADD id VARCHAR2(10);
ALTER TABLE Grade ADD CONSTRAINT Grade_fk_Member FOREIGN KEY (id) REFERENCES Member (id);
DROP TABLE Grade;
--dml
INSERT INTO Grade(grade_seq, score, exam_date, subj_id, member_id) VALUES(seq.nextval, '90', '2017-03', 'hong', 'java');
-- member_id를 입력하면 평균점수를 반환하는 sql
SELECT AVG(SCORE)
FROM ( SELECT DISTINCT
    M.MEMBER_ID ID,M.NAME,MJ.TITLE MAJOR,
    G.SCORE,SJ.TITLE SUBJECT, G.EXAM_DATE, G.GRADE_SEQ
    FROM MEMBER M, STUDENT S, GRADE G, SUBJECT SJ, MAJOR MJ 
    WHERE M.MEMBER_ID=S.MEMBER_ID 
        AND M.MEMBER_ID=G.MEMBER_ID 
        AND SJ.MAJOR_ID=MJ.MAJOR_ID 
        AND SJ.SUBJ_ID=G.SUBJ_ID) T
    WHERE T.ID='cho'; 
    
    
    
-- *******************
-- BOARD TABLE
-- 2017.08.02
-- 회원관리 테이블
-- member_id, name, password, ssn, regdate, major_id, phone, email, profile
-- *******************
--ddl
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
--dml
INSERT INTO Board(article_seq,member_id,title,content, hitcount,regdate) VALUES (seq.nextval, 'hong', '홍길동 안녕', '풀이 뜨고, 용감하고 약동하다.',0,SYSDATE);
UPDATE Board SET title='update',content='update' WHERE article_seq='1013';
DELETE FROM Board WHERE article_seq='';
SELECT COUNT(*) AS count FROM Board;
SELECT DISTINCT member_id FROM Board WHERE id LIKE '%o%';
SELECT SUM(article_seq) FROM Board;
SELECT * FROM board ORDER BY article_seq DESC;




-- *******************
-- JOIN QUERY
-- 2017.08.02
-- 조인 쿼리문
-- *******************
SELECT * FROM Member m, Board b WHERE m.id=b.id ORDER BY article_seq DESC;
SELECT * FROM MEMBER m, BOARD b WHERE m.id=b.id;
SELECT * FROM Member m, BOARD b, Grade g WHERE m.id=b.id AND m.id=g.id;
SELECT * FROM Member m, BOARD b WHERE m.id=b.id ROWNUM <=2;

SELECT *	
FROM(SELECT DISTINCT
    M.MEMBER_ID AS ID,M.NAME,MJ.TITLE AS MAJOR,
    G.SCORE,SJ.TITLE AS SUBJECT, G.EXAM_DATE, G.GRADE_SEQ
    FROM MEMBER M, STUDENT S, GRADE G, SUBJECT SJ, MAJOR MJ 
    WHERE M.MEMBER_ID=S.MEMBER_ID 
        AND M.MEMBER_ID=G.MEMBER_ID 
        AND SJ.MAJOR_ID=MJ.MAJOR_ID 
        AND SJ.SUBJ_ID=G.SUBJ_ID)
    WHERE ID='cho';

SELECT AVG(SCORE)
FROM ( SELECT
        M.MEMBER_ID ID, M.NAME name,
        G.SCORE score, G.EXAM_DATE
    FROM Grade g
        join Subject s on g.subj_id=s.subj_id
        join Member m on m.member_id=g.member_id
 )t
    WHERE T.ID='cho'; 
