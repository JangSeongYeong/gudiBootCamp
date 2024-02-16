/*DML(Data Manipulation Language)
 * 데이터를 다루는 언어(SELECT, INSERT, UPDATE, DELETE, UPSERT)
 */

-- employees 테이블 데이터 확인
select * from employees;

-- 1. 데이터 삽입
-- INSERT INTO [테이블명](컬럼명,...)VALUES(컬럼명에 넣을 값,...);
insert into employees(emp_no, first_name, family_name, email, mobile, salary, depart_no, commision)
	values(111,'성영','장','zxz0608@naver.com','01012341234',99999999,'dev01',90);
	
insert into employees(
	emp_no, 
	first_name, 
	family_name, 
	email, 
	mobile, 
	salary
)values(
	112,
	'태근',
	'김',
	'email@naver.com',
	'01043214321',
	9999999
);

insert into employees(
	emp_no, 
	family_name, 
	email, 
	mobile, 
	salary
)values(
	113,
	'김',
	'email@naver.com',
	'01043214321',
	99999999
);

-- 2. 데이터 삭제
-- DELETE FROM [테이블명] WHERE [조건];
-- delete from employees; -- 테이블이 삭제된다.
-- commision 이 null 인 값을 지워보자
delete from employees where commision is null;

-- 3. 데이터 수정
-- UPDATE [테이블명] SET [컬럼] = [값] WHERE [조건];
-- depart_no 가 dev005 인 row 에 대해서 commision 을 30 으로 변경
update employees set commision = 30 where depart_no = 'dev005';

-- 삭제, 수정은 where 주의

-- employees 테이블 데이터 확인
select * from employees;



