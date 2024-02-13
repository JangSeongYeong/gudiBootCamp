-- 주석 (-- )
/*1. 유저 생성*/
-- CREATE USER  [유저이름]@[접근가능한 IP] IDENTIFIED BY [비밀번호];

-- web_user 는 모든 IP 에서 접근 가능하고, 비밀번호는 pass 로 만들어라
create user 'web_user'@'%' identified by 'pass';

-- dba_user 는 192.168 로 시작되는 IP 에서 접근 가능하고, 비밀번호는 pass 로 만들어라
-- 특정 IP 대역만 접근 가능하게 할 경우
create user 'dba_user'@'192.168.%' identified by 'pass';

-- user002 는 192.168.38.70 IP 에서만 접근 가능하고, 비밀번호는 pass3 로 만들어라
create user 'user002'@'192.168.38.70' identified by 'pass3';

-- 유저 생성 확인
select * from mysql.user;

/*2. 권한 부여 및 회수*/
-- 권한 부여(GRANT)
-- GRANT [권한종류] ON	[데이터베이스.테이블] TO [유저명];
-- 데이터를 INSERT(추가), UPDATE(수정), SELECT(조회), DELETE(삭제)
-- ALL PRIVILEGES : GRANT OPTION 을 제외한 모든 권한 부여
-- GRANT OPTION : 권한을 주는 권한

-- dba_user 에게 모든 데이터베이스의 모든 테이블의 데이터를 볼 수 있는 권한을 준다.
-- user 명시할 때 IP 도 함께 명시해야 한다.
grant select on *.* to 'dba_user'@'192.168.%'; 

-- user002 에게 모든 데이터베이스의 모든 테이블의 데이터를 보고, 추가하고, 수정하고, 삭제할 수 있는 권한을 준다.
grant select, insert, update, delete on *.* to 'user002'@'192.168.38.70';

-- web_user 에게 모든 데이터베이스에 모든 테이블의 데이터를 뭐든지 할 수 있는(권한 주는거 제외) 권한을 준다.
-- IP 가 % 인 경우는 생략 가능
grant all privileges on *.* to 'web_user'@'%';
grant all privileges on *.* to 'web_user';

-- 유저 권한은 user 확인에서 가능하다.
select * from mysql.user;

/*유저 삭제*/
-- DROP USER [유저 이름]@[IP]
drop user 'dba_user'@'192.168.%';