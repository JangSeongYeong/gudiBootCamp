-- 1) PRIMARY KEY (기본키 제약조건)
-- 중복과 NULL 을 허용하지 않는다.
-- 테이블 종속적이다. (하나의 테이블에 하나의 PK)
-- 하나의 컬럼으로 하나의 PK 를 만들 수 있지만, 여러개의 컬럼을 합쳐서 만들 수도 있다.(최대 16개 까지 조합 가능)

-- 테이블 생성시 함께 생성(가장 많이 활용)
create table pk_test(
	first_col int(3) primary key,
	second_col varchar(4)
);
desc pk_test; -- PRI 가 있다면 제대로 된 것

-- 테이블 생성 후 추가
desc employees;
-- ALTER TABLE [테이블 명] ADD CONSTRAINT [제약조건 타입](적용필드);
alter table employees add constraint primary key(emp_no);
alter table employees add primary key(emp_no);

-- 일부러 중복 데이터 넣어보기
select * from employees order by emp_no;
-- SQL Error [1062] [23000]: (conn=56) Duplicate entry '119' for key 'PRIMARY'
insert into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(119,'향오','조','search@daum.net','01012341234',45000000);

-- UPSERT - 중복되는 키값이 있으면 수정, 없으면 삽입
insert into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(112,'태근','김','search@daum.net','01012341234',45000000)
on duplicate key update email = 'email@naver.com', salary=99999999;

select @@autocommit;

-- 복합키(combination key)
-- 하나의 컬럼으로 하나의 기본키를 구성하는 것이 가장 좋으나, 어쩔수 없는 경우 다수의 컬럼을 조합해서 기본키를 생성
-- 최대 16개 까지
-- 외래키를 이용해 복합키를 만드는 경우가 있는데, 이경우 UPDATE 나 INSERT 에 제한을 주므로 사용하지 않는 것이 좋다.
create table pk_tow_test(
	first_col int(5),
	second_col varchar(10),
	third_col date,
	primary key(first_col, second_col)
);
desc pk_tow_test;

-- 2) NOT NULL (NULL 을 허용하지 않음)
-- NOT NULL 은 제약 조건이지만 속성으로 취급
-- 기본적으로 생성하면서 넣는다. ex) first_col int(5) not null,
-- 테이블 생성 후 NOT NULL 넣기
-- ALTER TABLE [테이블명] MODIFY [컬럼명] (사이즈);
ALTER TABLE pk_test modify second_col varchar(4) not null;
desc pk_test;

-- 제약조건 확인
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'pk_tow_test';
-- 제약 조건 삭제
-- ALTER TABLE [테이블] DROP [제약조건 종류];
alter table pk_tow_test drop primary key;