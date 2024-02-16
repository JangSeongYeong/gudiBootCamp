-- RDBMS (Relation Data Base Management System)
-- 관계형 데이터 베이스

-- 1. 참조 제약 조건 (외래키 제약조건)
-- 1) 테이블 생성시 추가
create table parent_table(
	user_id varchar(30) primary key,
	user_name varchar(20),
	user_phone varchar(20),
	user_addr varchar(100)
);

-- 부모의 기본키를 외부에서 참조해 온다. -> 외래키 제약조건
create table child_table(
	order_id int(10)
	,user_id varchar(30) -- 앞으로 ,를 놔두면 복사로 실행할 때 ,인해 생기는 에러를 줄일 수 있다. 
	,product_name varchar(30)
	,price varchar(30)
	,qty varchar(30)
-- 	, foreign key(user_id) references parent_table(user_id)
);

-- 2) 테이블 생성 후 추가
-- ALTER TABLE [테이블 명] ADD CONSTRAINT [제약조건종류](적용필드) REFERENCES [가져올 테이블](가져올 컬럼)
alter table child_table add constraint foreign key(user_id) references parent_table(user_id);

select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'child_table';

/* 부모자식 관계란 부모의 기본키를 자식이 가져다 쓰는 관계이다.
 * 이때 부모의 기본키를 나의 기본키로 사용하는 경우를 '식별 관계' 라고 한다.
 * 그렇지 않을 경우는 '비식별 관계'라고 한다.
 */

-- 식별 관계 (완벽한 1대 1관계에서 사용해야 한다.)
create table iden_table(
	user_id varchar(30) primary key,
	foreign key(user_id) references parent_table(user_id)
);


-- 2. 연계 참조 무결성 제약조건
-- 부모자식간에 논리적으로 앞뒤 말이 맞아야 한다.

-- 모든 컬럼에 값을 넣을 경우 컬럼명을 생략해도 된다. (권장 사항은 아니다 - 코드는 다른사람도 봐야하기 때문에)
insert into parent_table values('user01','김철수','01012341234','서울 금천구');
insert into parent_table values('user02','홍길동','01012341234','서울 금천구');
insert into parent_table values('user03','박영수','01012341234','서울 금천구');
select * from parent_table;

insert into child_table values(1, 'user01', '의류', 6000, 1);
insert into child_table values(2, 'user02', '의류', 6000, 1);
insert into child_table values(3, 'user03', '의류', 6000, 1);
select * from child_table;

-- 부모한테 없는 값을 외래키에 넣으려고 하면 에러가 나타난다.
-- 연계 참조 무결성이 깨졌다.
-- 부모 테이블의 기본키는 user04가 없지만 자식이 그것을 쓰려고 했다. -> 부모없는 자식을 만들려고 함
-- SQL Error [1452] [23000]: (conn=58) Cannot add or update a child row
insert into child_table values(4,'user04', '의류', 6000, 1);

-- 부모를 지워 보자
-- SQL Error [1451] [23000]: (conn=58) Cannot add or update a child row:
delete from parent_table where user_id = 'user01';

-- 연계 참조 무결성을 해치지 않고 삭제하려면 자식이 먼저 삭제되고, 이후 부모가 삭제되어야 한다.
-- 이 과정을 자동으로 수행해 주는 ON DELETE CASCADE 옵션이 있다. (테이블 생성시에만 넣을 수 있는 옵션이다. "추가가 불가능")

create table supplier(
	sup_id int(10) primary key
	,sup_name varchar(50) not null
	,phone varchar(12)
);

create table products(
	pd_id int(10) primary key	
	,sup_id int(10)
	,price int(10)
	, foreign key (sup_id) references supplier (sup_id) on delete cascade
);

insert into supplier values(1,'김철수','01012341234');
insert into supplier values(2,'이철수','01012341234');
insert into supplier values(3,'박철수','01012341234');

insert into products values(1111,1,6000);
insert into products values(1112,2,6000);
insert into products values(1113,3,6000);

select * from supplier;
select * from products;

delete from supplier where sup_id = 1;


-- 3. unique 제약조건
-- 중복을 허용하지 않는 제약조건
-- 테이블에 다수 존재할 수 있다.
-- unique + not null = PK
-- 후보키 - 기본키가 될 수 있는 조건(중복X, not null)은 갖을 수 있으므로...
-- ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건종류](컬럼명);
alter table supplier add constraint unique(sup_name);
desc supplier;
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'supplier';

-- Duplicate entry '박철수' for key 'sup_name' : 이미 박철수라는 sup_name이 있다.
insert into supplier values(4,'박철수','01012341234');


-- 4. check 제약조건 (사용 X)
-- 조건이 맞지 않으면 받지 않는 제약 조건
-- ALTER TABLE[테이블명] ADD CONSTRAINT [제약조건종류](조건)
-- 주의 사항 : 조건은 기존 데이터가 만족해야할 조건을 걸어야 한다.

-- price 가 5000원 미만인 경우만 받겠다.
alter table products add constraint check(price < 5000); -- 이미 데이터가 5000이 넘어서 불가능

-- price 가 6000원보다 작은 경우만 받겠다.
alter table products add constraint check(price <= 6000);

insert into products values(1114,2,6000); -- 6000원 보다 크면 안들어간다.

-- 안쓰는 이유
-- 1. 조건의 유연성이 떨어진다.
-- 2. 조건 변경시 DDL 을 수정해야 한다.
-- 3. 어떤 조건이 걸려있는지 파악하기가 쉽지 않다. (DB 안에서 찾아야 함)
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'products';







