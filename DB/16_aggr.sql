-- ���� �Լ� : ���� �� �Ǵ� ���̺� ��ü ������ ���� �ϳ��� ��� ���� ��ȯ�ϴ� �Լ�

-- 1) COUNT(column) : �˻��� ���� ���� ��ȯ
select count(deptno) from dept d;

-- 2) MAX
select max(salary) from employees e ;

-- 3) MIN
select min(salary) from employees e ;

-- �ִ� �޿��� �޴� �����, �ּ� �޿��� �޴� ����� �̸��� �޿��� ����ϼ���
-- union all
select family_name, first_name, salary from employees where salary = (select max(salary) from employees)
	union all
select family_name, first_name, salary from employees where salary = (select min(salary) from employees);

-- in
select family_name, first_name, salary from employees
	where salary in ((select max(salary) from employees), (select min(salary) from employees));

-- 4) AVG : ��� ��ȯ
-- round(num, n) : num�� �Ҽ��� n�ڸ����� �ݿø�
select round(avg(salary),1) from employees;

-- 5) SUM : �� �հ� ��ȯ
select sum(salary) from employees where depart_no = 'dev004';

