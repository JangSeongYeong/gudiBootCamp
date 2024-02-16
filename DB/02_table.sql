select * from mysql.user;

/*D.D.L(Data Define Language)*/

-- 데이터 베이스 목록 보기
show databases;

-- 데이터 베이스 생성
-- CREATE DATABASE [데이터 베이스 이름];
create database mydb;

-- 데이터 베이스 삭제
-- DROP DATABASE [데이터 베이스 이름];

-- 데이터 베이스 사용
-- USE [데이터 베이스 이름];
use mydb;

-- 테이블 목록 확인
show tables;

-- 테이블 생성
-- CREATE TABLE [테이블명](
-- [컬럼명] [데이터타입](크기),
-- ...
-- );

/* 데이터타입 종류(자주 쓰는 일부)
 * 1) 문자 타입
 * 고정형 - 한 번 정해진 크기가 변하지 않음 (2글자로 선언했으나 1글자로 오면 남는 한 자리는 공백처리 됨) -- "남 "과 "남"은 다르다.
 * char(바이트 수)
 * 가변형 - 정해진 크기보다 적게 들어오면 알아서 줄여준다.
 * varchar(바이트 수)
 * text			: 65,535 byte -- 꽤 큰 바이트
 * longtext		: 4,294,967,295 byte -- 엄청 큰 바이트
 * 
 * 2) 숫자 타입 - int, long, float, double
 * 
 * 3) boolean 
 * 
 * 4) 날짜 타입
 * DATE				: 0000-00-00
 * DATETIME		: 0000-00-00 00:00:00
 * TIMESTAMP	: DATETIME 과 같지만 time zone 에 따라 시간이 변경 된다. (국제 서비스시에 사용)
 * */

create table test_table(
	user_name varchar(50),
	age int(3),
	mobile varchar(11),
	reg_date date default current_date -- 기본으로 현재 날짜를 넣는다.
);

-- 테이블 구조 보기
-- DESC [테이블 명]
desc test_table;


-- 테이블을 아래와 같이 만들어 보자
-- 테이블 명 : employees
-- emp_no 숫자형 3자리
-- first_name 문자열 8자
-- last_name 문자열 2자
-- email 문자열 50자
-- mobile 문자열 11자 + 여분 2자
-- salary 숫자형 8자
-- reg_date 날짜 기분으로 입력된다.

create table employees (
	emp_no int(3),
	first_name varchar(8),
	last_name varchar(4),
	email varchar(50),
	mobile varchar(13),
	salary int(8),
	reg_date date default current_timestamp
);

desc employees;

show tables;
-- 테이블 삭제
-- DROP [테이블 명]
drop table test_table;


-- CREATE 로 생성한 녀석은 DROP 으로 삭제하고 ALTER 로 수정한다.
-- 테이블 수정(컬럼에 대한 수정)
-- 1) 컬럼 이름 변경 (기존 데이터가 삭제된다.) -- 기존 데이터가 있을때 이름을 함부로 바꾸면 안된다.
-- ALTER TABLE [테이블 명] RENAME COLUMN [변경전 이름] TO [변경후 이름];
ALTER TABLE employees RENAME COLUMN last_name TO family_name;
desc employees;

-- 2) 컬럼 추가
-- ALTER TABLE [테이블 명] ADD ([컬럼명] [데이터 타입](크기));
ALTER TABLE employees ADD (depart_no varchar(10)); -- depart_no 문자열 10바이트
ALTER TABLE employees ADD (commision varchar(10)); -- commision 문자열 10 바이트
alter  table employees add (etc varchar(100)); -- etc 문자열 100 바이트

-- 3) 컬럼 속성 변경(해당 컬럼이 비어 있어야 한다.)
-- ALTER TABLE [테이블 명] MODIFY COLUMN [컬럼명] [데이터타입](크기);
ALTER TABLE employees MODIFY COLUMN commision float(4,2); -- float(전체 자릿수,소숫점 자릿수) -> 00.00
desc employees;

-- 4) 컬럼 삭제
-- ALTER TABLE [테이블 명] DROP COLUMN [컬럼명]
-- etc 삭제 해 보기
ALTER TABLE employees DROP COLUMN etc;

