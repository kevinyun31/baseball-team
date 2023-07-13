# 야구 게임 프로젝트
# 스키마
...sql
create schema kbo;

select * from stadium;
select * from team;
select * from player;
select * from out_player;


CREATE TABLE stadium (
stadium_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO stadium (name) VALUES ('사직');
INSERT INTO stadium (name) VALUES ('잠실');
INSERT INTO stadium (name) VALUES ('대구');


CREATE TABLE team  (
team_id INT AUTO_INCREMENT PRIMARY KEY,
stadium_id INT,
name VARCHAR(100) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (stadium_id) REFERENCES stadium(stadium_id)
);
INSERT INTO team(stadium_id,name) VALUES (1,'롯데');
INSERT INTO team(stadium_id,name) VALUES (2,'두산');
INSERT INTO team(stadium_id,name) VALUES (3,'삼성');

CREATE TABLE player (
player_id INT AUTO_INCREMENT PRIMARY KEY,
team_id INT,
name VARCHAR(100) NOT NULL,
position VARCHAR(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
CONSTRAINT uc_team_position UNIQUE (team_id, position),
FOREIGN KEY (team_id) REFERENCES team (team_id)
);
INSERT INTO player ( team_id , name, position) VALUES
-- 롯데 (team_id:1)
(1, '박세웅', '투수'),
(1, '유강남', '포수'),
(1,'안치홍', '1루수'),
(1,'박승욱', '2루수'),
(1,'노진혁', '유격수'),
(1,'한동희', '3루수'),
(1,'전준우', '좌익수'),
(1,'김민석', '중견수'),
(1,'윤동희', '우익수');


INSERT INTO player ( team_id , name, position) VALUES
-- 두산 (team_id:2)
( 2,'곽빈', '투수'),
( 2,'양의지', '포수'),
( 2,'양석환', '1루수'),
( 2,'강승호', '2루수'),
( 2,'이유찬', '유격수'),
( 2,'허경민', '3루수'),
( 2,'로하스', '좌익수'),
( 2,'정수빈', '중견수'),
( 2,'김대한', '우익수');

INSERT INTO player ( team_id , name, position) VALUES
-- 삼성(team_id:3)
(3, '뷰캐넌', '투수'),
(3,'강민호', '포수'),
(3, '오재일', '1루수'),
(3, '안주형', '2루수'),
(3, '이재현', '유격수'),
(3, '김호재', '3루수'),
(3, '로하스', '좌익수'),
(3, '김현준', '중견수'),
(3, '이성규', '우익수');







CREATE TABLE out_player (
out_player_id INT AUTO_INCREMENT PRIMARY KEY,
player_id INT,
reason VARCHAR(100),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (player_id) REFERENCES player (player_id)
);
INSERT INTO out_player (player_id,reason) VALUES
(1, '성적부진');




1. DB연결
2. 모델링
3. DAO 구현
4. DTO 구현
5. 
//insert 야구장 등록
//select 야구장 목록
//insert 팀 등록
//select 팀 목록

야구장 등록
- 
전체 야구장 목록
팀 등록
전체 팀 목록