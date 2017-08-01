--id, password, name, ssn, regdate

INSERT INTO Member(id, name, password, ssn, regdate) VALUES ('hong', '홍길동', '1', '800101-1234567', SYSDATE);
SELECT * FROM Member;--dml
SELECT * FROM Member WHERE name='홍길동';
SELECT * FROM Member WHERE id='hong'
SELECT COUNT(*) AS count FROM MEMBER;
UPDATE Member SET password='2' WHERE id='hong';
DELETE FROM Member WHERE id='cho1';

INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'hong', '홍길동 안녕', '풀이 뜨고, 용감하고 약동하다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'hong', 'Hi', '풀이 뜨고, 보이는 가는 모래뿐일 든 있는가?',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'hong', 'Bye', '위하여서, 착목한는 영락과 얼마나 있다. ',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'lee', '홍길동 안녕', '같으며, 커다란 풍부하게 같이 봄바람이다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'park', 'jiwon park', '우리 그들은 붙잡아 이것이다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'paek', '백성희 안녕', '없는 피부가 인간의 있는 곧 끝까지 날카로우나 끓는다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'cordon', 'james cordon', '인생을 얼마나 인류의 방황하였으며, 대중을 말이다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'brian', 'connan', '무한한 일월과 천하를 속잎나고, 뿐이다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'lam', 'jess', 'jess is from hk.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'cho', '현지니', 'gina works in a lab',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'cho1', 'gina', 'her English name is gina.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'song', '송혜미', '그들의 같이, 꽃이 것이다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'cho', 'again', ' 가슴이 풍부하게 풀밭에 위하여 풀이 몸이 이상은 있다. ',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'kim', '철수', '끓는 대고, 과실이 역사를 맺어, 운다. ',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'lee', 'young', ' 모래뿐일 이것을 우리의 그들의 그들의 보내는 꾸며 약동하다.',0,SYSDATE);
SELECT * FROM Board
INSERT INTO Board(article_seq,id,title,content, hitcount,regdate) VALUES (article_seq.nextval, 'hong', 'hey', '미묘한 가는 천지는 힘있다.',0,SYSDATE);
SELECT * FROM Board
UPDATE Board SET title='update',content='update' WHERE article_seq='1013';
DELETE FROM Board WHERE article_seq='';

SELECT * FROM Board;--dml
SELECT * FROM Board WHERE id='';
SELECT * FROM Board WHERE article_seq='1013';
SELECT COUNT(*) AS count FROM Board;