-- 1) 뷰
-- 여러 테이블의 데이터를 모아서 만든 가상 테이블이다.
-- 복잡한 서브쿼리나 조인이 필요한 쿼리문을 한번만 사용해서 뷰를 만들어 놓으면 이후 편리하게 사용 할 수 있다.
-- 뷰는 자신만의 인덱스를 가질 수 없다.
-- 뷰에 인덱스를 넣고 싶다면 컬럼의 원본 테이블에서 인덱스를 넣어야 한다.

-- 2) 뷰 생성 문법
-- CRAETE [OR REPLACE] VIEW [뷰이름] AS [뷰를 생성할 쿼리];
-- OR REPLACE : 기존 뷰를 수정할때 사용한다. (OR REPLACE를 넣지 않고 같은 이름이 있을 경우 피해간다.)
-- view는 보여주고 싶은거만 조합한다는 개념이기 때문에 절대 * 처리하지않는다.

create view name_query as 
	select e.ename, d.deptname from emp e join de	pt d
		on e.deptno = d.deptno; -- 등가조인
	
-- 3) 뷰 확인
-- show create view [뷰이름]; -- 구성 쿼리도 보여줌
show create view name_query;
show full tables where table_type = 'VIEW'; -- 항목만 보여줌
-- 4) 뷰 사용 : 테이블 사용과 같음
select * from name_query;

-- 뷰에서 수정을 가하면 원본 테이블의 데이터도 수정된다.
update name_query set ename = 'oh' where ename = 'Kim';
select * from  emp;
-- Kim 이 남아있는 이유는 6번의 경우 등가조인의 조건에 맞지 않아 뷰에 포함되지 않았기 때문에 뷰에서 수정했을때 영향을 받지 않았다.

-- 5) 뷰 수정
-- ALTER로 수정 가능하지만 일반적으로 OR REPLACE 를 사용한다. (없으면 생성, 있으면 덮어쓰기)
-- 있으면 수정하고, 없으면 만들기 때문에
create or replace view name_query as 
	select e.ename, d.deptname, d.loc from emp e join dept d on e.deptno = d.deptno;

select * from name_query;

-- 6) WITH CHECK OPTION : 뷰를 생성한 조건식을 만족하는 컬럼에 대해서는 수정을 막는 옵션
create view chk_option as select ename, job, deptno from emp where deptno = 1 with check option;
select * from chk_option;
-- 일반적인 수정은 모두 가능하다.
update chk_option set job = 'manager' where ename = 'lee';

-- 뷰를 만든 조건인 deptno 는 수정 불가능하다.
update chk_option set deptno = '2' where ename = 'lee';

-- 변경해주고 싶다면 원본 테이블에서 수정해야 한다.
update emp set deptno = '2' where ename = 'lee' and job = 'manager';
select * from emp;

-- 7) 뷰 삭제
-- DROP VIEW [뷰이름]
drop view chk_option;
drop view name_query;

show full tables where table_type='VIEW';
