select * from employees e ; -- 14��
-- 5�� ��
-- 0~4, 5~9 10~14
-- limit n : n�� �����ֱ�
select * from employees e limit 5;

-- limit n,m : n�� ���� m ��
select * from employees e limit 0, 5;
select * from employees e limit 5, 5;
select * from employees e limit 10, 5;

-- offset n : n�� ����
select * from employees e limit 5 offset 0;
select * from employees e limit 5 offset 5;
select * from employees e limit 5 offset 10;

-- �� ������ �Ϲ����� ����¡ ó�� ���
-- �� ����� �����Ͱ� �������� ��������.
-- offset�� ������ ���ؼ� �ϳ��� ���鼭 �������� ����

-- �ӵ� ���� 1�ܰ�> �����͸� ���� �� ������ �����´�.
select e.emp_no, e.first_name, e.family_name 
	from (select * from employees e order by emp_no) e
		limit 0, 5;	

-- �ӵ� ���� 2�ܰ�> �ε����� ���ٸ� �ε��� �߰�
desc employees;
-- �ε����� �ִٸ� Ȱ��

select e.emp_no, e.first_name, e.family_name 
	from (select * from employees e order by emp_no limit 0, 5) e
	join employees e2 on e.emp_no = e2.emp_no;	
-- �̰� �� ������?
-- ������ ���ؼ� �̹� ����� �ε����� Ȱ���ؼ� ���� ã�� ����̹Ƿ� �� ������.

