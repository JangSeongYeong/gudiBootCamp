/*IN & EXISTS*/
-- 부서가 LA 또는 BOSTON 에 있는 직원의 이름과 직책
select ename, job from emp where deptno in(select deptno from dept where loc in('la','boston'));

-- 1. IN : '=' 비교만 가능(크다, 작다 비교 안됨), OR 조건의 검색 결과 내용을 가져온다. , "같은 컬럼에서 여러개를 동일만을 비교"하는 OR 조건일 경우 사용
-- 서브쿼리가 먼저 실행되고 그 결과를 가지고 메인 쿼리를 실행한다.

-- 2. EXISTS : 메인쿼리의 비교 조건이 서브쿼리의 결과 중에서 '만족하는 값이 하나라도 존재한다면' 참(1)/거짓(0)으로 반환
-- 메인쿼리가 먼저 실행되고, 이후 서브쿼리가 실행된다. (중요1)
select exists (select deptno from dept where loc = 'la' or loc = 'boston') as bool;

-- 메인쿼리 실행 후 데이터를 exists 조건이 참이 되면 모든 내용을 보여주고
select ename, job, deptno from emp 
	where exists (select deptno from dept where loc = 'la' or loc = 'boston');

select * from emp where 1;

-- 참이 아니라면 아무것도 보여주지 않는다.
select ename, job, deptno from emp 
	where exists (select deptno from dept where loc = 'korea');

select * from emp where 0;

-- 위 특성을 가지고 어떻게 써먹을 것인가?
-- 1) 메인쿼리가 실행되어 데이터를 확보하고
select ename, job, deptno from emp;

-- 2) 확보한 데이터로부터 dept 와 연결 해 준다.
-- 양쪽 둘 다 있는 데이터만 가져옴
-- 아까 같이 왜 모든 데이터를 보여주지 않았는가? (6번을 안보여줌)
-- 메인 쿼리와 서브쿼리 간에 공통된 컬럼을 조건으로 걸고 있어서 (메인쿼리와 서브쿼리 간에 연결되어 있다.)
select ename, job, deptno
	from emp e where exists (select deptno from dept d where e.deptno = d.deptno);

-- 3) 걸러낸 녀석들 중에서 dept 에서 loc 가 la 이거나 boston 인 녀석만 골라내면 된다.
select ename, job, deptno
	from emp e where exists (
		select deptno from dept d where e.deptno = d.deptno and (d.loc = 'boston' or d.loc = 'la')
	);

select ename, job from emp where deptno in(select deptno from dept where loc in('la','boston')); -- 이거 보다 빠름

/* IN 이 EXISTS 보다 사용은 쉽지만 속도는 느리다.
 * SQL 에서는 데이터를 확보해 놓고 다음작업을 진행하는 것이 빠르기 때문이다.
 * EXISTS 는 메인쿼리를 통해 데이터를 확보하고, 서브쿼리 내용으로 일치하는 내용을 보여주기 때문에 속도가 더 빠르다.
 * -- 데이터가 있는지 없는지 확인하는 방법으로도 사용한다 (EXISTS)
 * */
-- 하나의 작업을 먼저 해놓고 다른 작업을 하는게 속도가 빠르다. (중요 2)


/*ANY & ALL*/
-- 3. ANY : 메인 쿼리의 비교조건이 서브쿼리의 결과중에 하나라도 일치하면 참.
-- IN 처럼 쓸 수도 있고, 크다/작다를 활용할 수 있다.
-- 1) = ANY : IN 과 같은 효과
select ename, job from emp where deptno in (select deptno from dept where loc in('la','boston')); 
select ename, job from emp where deptno = any (select deptno from dept where loc in('la','boston')); 

-- 직책이 manager 인 직원중 입사일이 가장 빠른 사람보다, 늦게 입사한 사람의 직책과 입사일을
select job, hiredate from emp where hiredate > (select min(hiredate) from emp where job = 'manager') order by hiredate;
-- 2) > ANY : 최소값 보다 크면
select job, hiredate from emp where hiredate > any (select hiredate from emp where job = 'manager') order by hiredate;


-- 직책이 manager 인 직원중 입사일이 가장 늦은 사람보다, 빨리 입사한 사람의 직책과 입사일을
select job, hiredate from emp where hiredate < (select max(hiredate) from emp where job = 'manager') order by hiredate;
-- 3) < ANY : 최대값 보다 작으면
select job, hiredate from emp where hiredate < any (select hiredate from emp where job = 'manager') order by hiredate;

-- 4. ALL : ANY 와 반대
-- 1) = ALL : = ANY 와 같지만 AND 조건이다.
select ename, job from emp where deptno = all(select deptno from dept where loc = 'boston');
-- 서브 쿼리 안의 값이 여러개가 나타날 경우 사용하면 안된다.

-- 2) > ALL : 최대값 보다 크면
-- 직책 manager 인 직원중 입사일이 가장 늦은 사람보다, 더 늦게 입사한 사람의 직책과 입사일을
select job, hiredate from emp where hiredate > (select max(hiredate) from emp where job = 'manager') order by hiredate;
select job, hiredate from emp where hiredate > all (select hiredate from emp where job = 'manager') order by hiredate;

-- 3) < ALL : 최소값보다 작으면
-- 직책 manager 인 직원중 입사일이 가장 빠른 사람보다, 더 빨리 입사한 사람의 직책과 입사일을
select job, hiredate from emp where hiredate < (select min(hiredate) from emp where job = 'manager') order by hiredate;
select job, hiredate from emp where hiredate < all (select hiredate from emp where job = 'manager') order by hiredate;


