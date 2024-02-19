-- 집계 함수 : 여러 행 또는 테이블 전체 행으로 부터 하나의 결과 값을 반환하는 함수

-- 1) COUNT(column) : 검색된 행의 갯수 반환
select count(deptno) from dept d;

-- 2) MAX
select max(salary) from employees e ;

-- 3) MIN
select min(salary) from employees e ;

-- 최대 급여를 받는 사람과, 최소 급여를 받는 사람의 이름과 급여를 출력하세요
-- union all
select family_name, first_name, salary from employees where salary = (select max(salary) from employees)
	union all
select family_name, first_name, salary from employees where salary = (select min(salary) from employees);

-- in
select family_name, first_name, salary from employees
	where salary in ((select max(salary) from employees), (select min(salary) from employees));

-- 4) AVG : 평균 반환
-- round(num, n) : num의 소숫점 n자리에서 반올림
select round(avg(salary),1) from employees;

-- 5) SUM : 총 합계 반환
select sum(salary) from employees where depart_no = 'dev004';

