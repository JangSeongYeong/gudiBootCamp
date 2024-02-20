use employees;
show tables;

select * from current_dept_emp limit 10; 		-- �μ� �̵� �� (�����ȣ, �μ���ȣ, ����μ��� ���� ��¥, ���� ��¥)
select * from departments order by dept_no limit 10; 					-- �μ���ȣ�� �μ� �̸� (�μ���ȣ, �μ���)
select * from dept_emp limit 15; 						-- �μ� �̵� �� (�����ȣ, �μ���ȣ, ���� �μ��� ���� ��¥, ���� ��¥)
select * from dept_emp_latest_date limit 10; 	-- �ֽ� (�����ȣ, ����μ� ���� ����, �����)
select * from dept_manager limit 10; 				-- �� �μ� �Ŵ��� ���� (�����ȣ, �μ���ȣ, ����μ� ���� ��¥, ���� ��¥)
select * from employees limit 10;						-- ���� ���� ���� (�����ȣ, ����, �̸�, ��, ����, �Ի���)
select * from salaries limit 10; 						-- ����� ���� ���� (�����ȣ, ����, �� ����, �� ��)
select * from titles limit 10; 							-- ����� ��å ����(�����ȣ, ��å, ��å ������, ��å ������ ��)

show index from employees;
-- ������ �ľ� �Ҷ��� limit�� ����Ͽ� ������ �ľ��Ѵ�.
-- ���̺� ������ �ڽ��� �����ϴ� �� �߿� (���̺� ������ ���� ���� ����)

-- �������
select * from employees limit 10;
-- ��å �����丮 (employees�� �ڽ�)
select * from titles limit 10;
-- �޿����� (employees�� �ڽ�)
select * from salaries limit 10;
-- Ư�� �μ� �Ŵ��� �����丮 (employees, departments)
select * from dept_manager limit 10;
-- Ư���μ� ���� �����丮 (employees,departments)
select * from dept_emp;
-- �� ��� (����Ű)
select * from departments limit 10;


-- ���� 1> ������� �̸�(��, �̸� ���ļ�)�� �Ի���, ��å�� �Ի����� ���� ������ �����ּ���.
-- employees���� ��� �̸�, �Ի���, �Ի��� �� ����
select CONCAT(first_name,' ',last_name) as name, hire_date from employees order by hire_date; 
-- titles���� ��å title�� ����
select title from titles;
-- ��ģ �� �Ի��� ������ ����
select CONCAT(e.first_name, ' ', e.last_name) as name, e.hire_date, t.title 
	from employees e join titles t on e.emp_no = t.emp_no order by e.hire_date;

-- �ذ� join
select emp_no, concat(first_name, ' ', last_name) as name, hire_date from employees order by hire_date;
select emp_no, title from titles;

select concat(first_name, ' ', last_name) as name, hire_date, t.title
	from employees e, titles t where e.emp_no = t.emp_no order by hire_date;

-- �ذ� subQry(���ϰ���)
-- Subquery returns more than 1 row : ������������ �޾ƿ��� �����Ͱ� �� ���� �ƴϴ�.
select concat(first_name, ' ', last_name) as name, hire_date,
	(select title from titles t where e.emp_no = t.emp_no)
	from employees e order by hire_date;

-- ��? e.emp_no = t.emp_no �� 1:1 �� �ƴѰ�? : ��å ���̺��� ���縸�� �ƴ� ���� ��å���� ���ԵǾ� �־
-- �ߺ� Ȯ�� �۾�
select count(emp_no) from employees
	union all
select count(distinct emp_no) from titles;

-- ���� 2> dept_emp �� �������� �������� ���İ� ����� �̸��� ���ϼ���
-- step 1 -- ��ó�� �ο� ����
select emp_no, count(emp_no) as cnt from dept_emp group by emp_no having cnt > 1;

-- step 2   
-- 47ms (���ϰ���)
select e.emp_no, concat(first_name, ' ', last_name) as name 
	from employees e where e.emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1);

-- 94ms (join)
select e.emp_no, concat(first_name, ' ', last_name) as name 
	from (select emp_no from dept_emp group by emp_no having count(emp_no) > 1) de join employees e
	on e.emp_no = de.emp_no;
-- �̷��� ����� �������� ���ð�� �ؿ� ����� �ð��� �����غ��� ���� �� �ִ�.


-- ���� 3> �� �ο��� � ������ � ������ �̵��ߴ��� �����ּ���
-- ��� ��ȣ, ����ȣ, ������ ������
select emp_no, dept_no, from_date, to_date from dept_emp de
	where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1);

-- ��� ��, ����, ������, ������
-- ȥ��
select concat(first_name, ' ', last_name) as name, (select dept_name from departments d where d.dept_no = de.dept_no) as dept_name, de.from_date, de.to_date
	from (select emp_no, dept_no, from_date, to_date from dept_emp de where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1)) de 
	left join employees e
	on de.emp_no = e.emp_no
order by e.emp_no, de.from_date;

-- �ذ�
select
	concat(first_name, ' ', last_name) as name ,d.dept_name ,de.from_date, de.to_date
from 
	(select * from dept_emp
		where emp_no in(select emp_no from dept_emp group by emp_no having count(emp_no) > 1)) de 
	join employees e on de.emp_no = e.emp_no 
	join departments d on de.dept_no = d.dept_no;


-- ���� 4> �Ŵ������� �̸�, ����, �Ի���, ��å, ��å �Ⱓ(from, to)
-- �Ŵ��� ���ϴ� ���̺� : dept_manager
-- ��å ��å�Ⱓ : titles;
-- �̸� ���� �Ի��� : employees
select * from dept_manager dm;
select * from employees e;
select * from titles t ;

-- ȥ��
select 
	dm.dept_no, concat(first_name, ' ', last_name) as name, e.gender, e.hire_date, t.title, t.from_date, t.to_date
from employees e 
	join (select emp_no, dept_no from dept_manager) dm on e.emp_no = dm.emp_no
	join titles t on e.emp_no = t.emp_no
	where t.to_date > curdate() and t.title = 'manager';

-- �ذ�
-- ���� ���� ���� ���̺��� ����
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


-- ���������� �������� ����
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


-- ���� 5> ������� ���, �̸�, ���� ��å�� �޿�
-- �̸� : employees
-- ��å : titles
-- �޿� : salaries
select * from salaries limit 10; 
select * from titles t2 limit 10; 
select * from employees e2 limit 10;
-- ȥ��
-- ���� ��å
select emp_no, title from titles where to_date > curdate(); 
-- ���� �޿�
select emp_no, salary from salaries where to_date > curdate();

select 
	e.emp_no
	,concat(e.first_name, ' ', e.last_name) as name
	,t.title
	,s.salary
from employees e
	join (select emp_no, title from titles where to_date > curdate()) t on e.emp_no = t.emp_no
	join (select emp_no, salary from salaries where to_date > curdate()) s on t.emp_no = s.emp_no;

-- �ذ�
-- employees �����ڰ� ���ԵǾ��ִ����� �����ڵ� ��
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

