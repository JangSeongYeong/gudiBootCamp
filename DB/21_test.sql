use employees;
show tables;

select * from current_dept_emp limit 10; 		-- 부서 이동 전 (사원번호, 부서번호, 현재부서에 들어온 날짜, 나간 날짜)
select * from departments order by dept_no limit 10; 					-- 부서번호별 부서 이름 (부서번호, 부서명)
select * from dept_emp limit 15; 						-- 부서 이동 후 (사원번호, 부서번호, 현재 부서에 들어온 날짜, 나간 날짜)
select * from dept_emp_latest_date limit 10; 	-- 최신 (사원번호, 현재부서 들어온 다음, 퇴사일)
select * from dept_manager limit 10; 				-- 각 부서 매니저 정보 (사원번호, 부서번호, 현재부서 들어온 날짜, 나간 날짜)
select * from employees limit 10;						-- 개인 인적 사항 (사원번호, 생일, 이름, 성, 성별, 입사일)
select * from salaries limit 10; 						-- 사원별 연봉 내역 (사원번호, 연봉, 일 시작, 일 끝)
select * from titles limit 10; 							-- 사원별 직책 정보(사원번호, 직책, 직책 시작일, 직책 끝나는 일)

show index from employees;
-- 데이터 파악 할때는 limit를 사용하여 내용을 파악한다.
-- 테이블 내용을 자신이 정리하는 것 중요 (테이블 명세서가 없을 수도 있음)

-- 사원정보
select * from employees limit 10;
-- 직책 히스토리 (employees의 자식)
select * from titles limit 10;
-- 급여내역 (employees의 자식)
select * from salaries limit 10;
-- 특정 부서 매니저 히스토리 (employees, departments)
select * from dept_manager limit 10;
-- 특정부서 팀원 히스토리 (employees,departments)
select * from dept_emp;
-- 팀 목록 (복합키)
select * from departments limit 10;


-- 문제 1> 사원들의 이름(성, 이름 합쳐서)과 입사일, 직책을 입사일이 빠른 순으로 보여주세요.
-- employees에서 사원 이름, 입사일, 입사일 순 정렬
select CONCAT(first_name,' ',last_name) as name, hire_date from employees order by hire_date; 
-- titles에서 직책 title를 추출
select title from titles;
-- 합친 후 입사일 순으로 정렬
select CONCAT(e.first_name, ' ', e.last_name) as name, e.hire_date, t.title 
	from employees e join titles t on e.emp_no = t.emp_no order by e.hire_date;

-- 해결 join
select emp_no, concat(first_name, ' ', last_name) as name, hire_date from employees order by hire_date;
select emp_no, title from titles;

select concat(first_name, ' ', last_name) as name, hire_date, t.title
	from employees e, titles t where e.emp_no = t.emp_no order by hire_date;

-- 해결 subQry(상하관계)
-- Subquery returns more than 1 row : 서브쿼리에서 받아오는 데이터가 한 개가 아니다.
select concat(first_name, ' ', last_name) as name, hire_date,
	(select title from titles t where e.emp_no = t.emp_no)
	from employees e order by hire_date;

-- 왜? e.emp_no = t.emp_no 가 1:1 이 아닌가? : 직책 테이블에는 현재만이 아닌 이전 직책까지 포함되어 있어서
-- 중복 확인 작업
select count(emp_no) from employees
	union all
select count(distinct emp_no) from titles;

-- 문제 2> dept_emp 를 기준으로 여러팀을 거쳐간 사원의 이름을 구하세요
-- step 1 -- 거처간 인원 추출
select emp_no, count(emp_no) as cnt from dept_emp group by emp_no having cnt > 1;

-- step 2   
-- 47ms (상하관계)
select e.emp_no, concat(first_name, ' ', last_name) as name 
	from employees e where e.emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1);

-- 94ms (join)
select e.emp_no, concat(first_name, ' ', last_name) as name 
	from (select emp_no from dept_emp group by emp_no having count(emp_no) > 1) de join employees e
	on e.emp_no = de.emp_no;
-- 이렇게 방법이 여러개가 나올경우 밑에 실행된 시간을 측정해봐서 비교할 수 있다.


-- 문제 3> 각 인원이 어떤 팀에서 어떤 팀으로 이동했는지 보여주세요
-- 사원 번호, 팀번호, 시작일 종료일
select emp_no, dept_no, from_date, to_date from dept_emp de
	where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1);

-- 사원 명, 팀명, 시작일, 종료일
-- 혼자
select concat(first_name, ' ', last_name) as name, (select dept_name from departments d where d.dept_no = de.dept_no) as dept_name, de.from_date, de.to_date
	from (select emp_no, dept_no, from_date, to_date from dept_emp de where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1)) de 
	left join employees e
	on de.emp_no = e.emp_no
order by e.emp_no, de.from_date;

-- 해결
select
	concat(first_name, ' ', last_name) as name ,d.dept_name ,de.from_date, de.to_date
from 
	(select * from dept_emp
		where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1)) de 
	join employees e on de.emp_no = e.emp_no 
	join departments d on de.dept_no = d.dept_no;


-- 문제 4> 매니저들의 이름, 성별, 입사일, 직책, 직책 기간(from, to)
-- 매니저 구하는 테이블 : dept_manager
-- 직책 직책기간 : titles;
-- 이름 성별 입사일 : employees
select * from dept_manager dm;
select * from employees e;
select * from titles t ;

-- 혼자
select 
	dm.dept_no, concat(first_name, ' ', last_name) as name, e.gender, e.hire_date, t.title, t.from_date, t.to_date
from employees e 
	join (select emp_no, dept_no from dept_manager) dm on e.emp_no = dm.emp_no
	join titles t on e.emp_no = t.emp_no
	where t.to_date > curdate() and t.title = 'manager';

-- 해결
-- 정리 하지 않은 테이블을 조인
select 
	dm.name
	,dm.gender
	,dm.hire_date
	,t.title 
	,t.from_date 
	,t.to_date 
from (
	select 
		emp_no
		,concat(e.first_name, ' ', e.last_name) as name
		,e.gender
		,e.hire_date
	from employees e where emp_no in(select emp_no from dept_manager where to_date > curdate())
) dm join  titles t on dm.emp_no = t.emp_no;


-- 서브쿼리대 서브쿼리 조인
select 
	dm.name
	,dm.gender
	,dm.hire_date
	,t.title 
	,t.from_date 
	,t.to_date 
from (
	select 
		emp_no
		,concat(e.first_name, ' ', e.last_name) as name
		,e.gender
		,e.hire_date
	from employees e where emp_no in(select emp_no from dept_manager where to_date > curdate())
) dm join (select emp_no ,title , from_date , to_date from titles t where to_date > curdate()) t on dm.emp_no = t.emp_no;


-- 문제 5> 사원들의 사번, 이름, 현재 직책과 급여
-- 이름 : employees
-- 직책 : titles
-- 급여 : salaries
select * from salaries limit 10; 
select * from titles t2 limit 10; 
select * from employees e2 limit 10;
-- 혼자
-- 현재 직책
select emp_no, title from titles where to_date > curdate(); 
-- 현재 급여
select emp_no, salary from salaries where to_date > curdate();

select 
	e.emp_no
	,concat(e.first_name, ' ', e.last_name) as name
	,t.title
	,s.salary
from employees e
	join (select emp_no, title from titles where to_date > curdate()) t on e.emp_no = t.emp_no
	join (select emp_no, salary from salaries where to_date > curdate()) s on t.emp_no = s.emp_no;

-- 해결
-- employees 현직자가 포함되어있는지와 현직자들 수
select count(emp_no) from titles where to_date > curdate()
union all
select count(emp_no) from salaries where to_date > curdate()
union all
select count(emp_no) from employees e;

select
	e.emp_no
	,e.name
	,t.title
	,s.salary
from (
	select 
		emp_no
		,concat(first_name, ' ', last_name) as name
		from employees where emp_no in(select emp_no from salaries where to_date = '9999-01-01')
) e join titles t on e.emp_no = t.emp_no
join (select emp_no, salary from salaries where to_date = '9999-01-01') s on e.emp_no = s.emp_no;

