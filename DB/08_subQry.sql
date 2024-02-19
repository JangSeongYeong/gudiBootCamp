-- 서브 쿼리 : 쿼리 안의 쿼리
-- 하나의 쿼리문으로 받아온 데이터를 바탕으로 다른 내용을 검색할 때
-- 1. 추출된 결과로 다른 내용을 검색시
-- 2. 검색된 내용을 가상의 컬럼으로 볼때

--  서브쿼리의 결과물이 본 쿼리의 일부로 사용될 경우 - 컬럼, 테이블로 활용이 된다. (중요)

create table dept( -- 부서
	deptno varchar(10) primary key
	, deptname varchar(20)
	, loc varchar(10)
);

create table emp( -- 사원
	ename varchar(20)
	, job varchar(50)
	, deptno varchar(10)
	, hiredate date
);

alter table emp add constraint foreign key(deptno) references dept(deptno);

insert into dept(deptno, deptname, loc) values('1','sales','newyork');
insert into dept(deptno, deptname, loc) values('2','dev01','la');
insert into dept(deptno, deptname, loc) values('3','personnel','newyork');
insert into dept(deptno, deptname, loc) values('4','delevery','boston');

insert into emp(ename, job, deptno, hiredate) 
	values('kim', 'manager', '1', str_to_date('16/01/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('lee', 'staff', '1', str_to_date('15/01/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('han', 'staff', '1', str_to_date('16/03/02','%Y/%m/%d'));	
insert into emp(ename, job, deptno, hiredate) 
	values('kim', 'assistant', '1', str_to_date('15/09/22','%Y/%m/%d'));

insert into emp(ename, job, deptno, hiredate) 
	values('ahn', 'staff', '2', str_to_date('15/11/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('hwang', 'manager', '2', str_to_date('15/08/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('cha', 'assistant', '2', str_to_date('12/03/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('hong', 'staff', '2', str_to_date('14/08/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('gang', 'staff', '2', str_to_date('10/01/02','%Y/%m/%d'));

insert into emp(ename, job, deptno, hiredate) 
	values('name', 'leader', '4', str_to_date('10/01/02','%Y/%m/%d'));


-- 문제1> 'han' 의 근무 부서는?
-- emp 테이블에서 han 의 deptno 를 알아낸다.
select deptno from emp where ename = 'han'; -- 1
-- deptno 를 통해 dept 의 deptname 을 알아낸다.
select deptname from dept where deptno = '1';
-- 해결
select deptname, loc from dept where deptno = (select deptno from emp where ename = 'han');

-- 문제2> 부서 위치가 'la' 또는 'boston'인 부서 소속의 사람들에 이름 ,직책은?
-- 위치에 따른 부서 번호
select deptno from dept where loc in('boston', 'la'); -- 2, 4
-- 부서 번호에 맞는 사람과 직책
select ename, job from emp where deptno in('2', '4');
-- 해결
select ename, job from emp where deptno in((select deptno from dept where loc in('boston', 'la')));
-- 심심해서 한 OR로 길게 쓰기
select ename, job from emp where deptno =(select deptno from dept where loc ='boston') OR deptno =(select deptno from dept where loc ='la');

-- 문제 3> salse 부서에 근무하는 사원 데이터(ename, job, hiredate) 가져오기
-- salse가 부서 번호
select deptno from dept where deptname = 'sales'; -- 1
-- salse 사원 데이터(ename, job, hiredate)
select ename, job, hiredate from emp where deptno = '1';
-- 해결
select ename, job, hiredate from emp where deptno = (select deptno from dept where deptname = 'sales');

-- 문제 4> 직책(job)이 manger 인 사원들(여러명일 경우 빠른 직원 기준)보다 입사일이 빠른 직원은(ename, job, hiredate)은?
-- 매니저 정렬 후 가장 입사일 빠른 직원
select * from emp where job = 'manager' order by hiredate; -- 두 개 나오지만 가장 빠른건 2015-08-12
-- 매니저 중 가장 빠른 입사일 인사람 과 비교
select ename, job, hiredate from emp where hiredate < '2015-08-12' order by hiredate; 
-- 해결 1>
select ename, job, hiredate from emp 
	where hiredate < (select hiredate from emp where job = 'manager' order by hiredate limit 1) 
	order by hiredate; -- limit n : 가장 상위에 값 n
-- 해결 2>
select ename, job, hiredate from emp 
	where hiredate < (select min(hiredate) from emp where job = 'manager') order by hiredate;

-- 문제 5> 부서별(deptno, deptname)로 직원이 몇명인지 확인
-- deptno 그룹화 후 데이터 갯수 측정
select deptno, count(deptno) as scnt  from emp group by deptno; -- count(*) : 조회되는 데이터의 갯수

select count(deptno) from emp where deptno = 1; -- 4
select count(deptno) from emp where deptno = 2; -- 5
select count(deptno) from emp where deptno = 4; -- 1

select deptno, deptname from dept where deptno = 1;
select deptno, deptname from dept where deptno = 2;
select deptno, deptname from dept where deptno = 4;

-- 상하 관계 쿼리
-- 서브쿼리의 결과물이 본 쿼리의 일부로 사용될 경우
-- 컬럼, 테이블로 활용이 된다. (중요)
select deptno, deptname, (select count(deptno) from emp where deptno = 1) as cnt from dept where deptno = 1;
select deptno, deptname, (select count(deptno) from emp where deptno = 2) as cnt from dept where deptno = 2;
select deptno, deptname, (select count(deptno) from emp where deptno = 4) as cnt from dept where deptno = 4;

-- 해결>
select deptno, deptname, (select count(deptno) from emp where deptno = d.deptno) as cnt 
	from dept d; -- dept d  또는 dept as d : 별칭 (상하 관계 쿼리에 적용가능)

-- 해결2> group by 사용
select deptno
	,(select deptname from dept where deptno = emp.deptno) as deptname
	,count(deptno) as cnt
	from emp group by deptno; -- group by에서 카운트는 없는 친구는 count X


