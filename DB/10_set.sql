-- 다수의 테이블을 집합 연산 할 수 있다.
-- 합집합(UNION, UNION ALL), 교집합(INTERSECT), 차집합(MINUS)이 존재한다.
-- 중복 제거를 해주는 UNION 은 성능저하 문제로 권장하지 않는다. (합치고 확인하는게 아닌 하나씩 확인하면서 중복을 확인해서 성능저하게 발생한다.)
-- [qry1] [UNION | UNION ALL | INTERSECT | MINUS] [qry2]

-- 1. UNION : 중복을 제거한 합집합
select deptno from emp
	union
select deptno from dept order by deptno;

-- left join 과 right join 을 union 하면 full outer join 효과를 얻을 수 있다.
select e.deptno, e.ename, d.deptname from emp e left join dept d on e.deptno = d.deptno
	union
select d.deptno, e.ename, d.deptname from emp e right join dept d on e.deptno = d.deptno order by deptno;


-- 2. UNION ALL : 중복제거 없이 합집합 실행
-- UNION ALL 을 순수하게 사용한다기 보다는 정제해서 사용한다.
select deptno from emp
	union ALL
select deptno from dept order by deptno;


-- 3. INTERSECT : 양 테이블에 존재하는 중복된 데이터만 확인한다.
select deptno from emp
	intersect
select deptno from dept order by deptno;


-- 4. MINUS : MariaDB 에서는 차집합을 지원하지 않는다.
select distinct deptno to from emp; -- 1,2,4,6 
select distinct deptno to from dept; -- 1,2,3,4,5

-- emp - dept = 6
select deptno from emp where deptno not in (select deptno from dept);

-- dept - emp = 3,5
select deptno from dept where deptno not in (select deptno from emp);

-- emp 와 dept 를 합집합 한 내용을 emp 와 교집합
select deptno from emp
	union
select deptno from dept
	intersect
select deptno from emp;

-- union 을 대체할 경우?
-- 1. 일단 합친다.
-- 2. 합친 내용을 가지고 중복 제거
select distinct u.deptno from
	(select deptno from emp
		union all
	select deptno from dept) as u
order by u.deptno;
-- 속도를 빠르게 하려면 무조건 데이터를 확보를 하고 진행해야 한다.