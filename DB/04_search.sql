-- 1. ������ ��ȸ
-- 1) Ư�� �÷� ��ȸ
-- SELECT [��ȸ�� �÷�] FROM [���̺��];
select * from employees;
select first_name, family_name, mobile from employees;
-- � ���� ������ ���ΰ�? �װ��� � ���̺� �ִ°�? �� ������ ���� �߿��� ����̴�.

-- ��� ǥ��
-- ���ڷε� �÷��� ���ؼ��� ����ؼ� ������ �� �ִ�.(������ ���Ǵ� �� �ƴ�)
select first_name, family_name, salary/10000 from employees; -- �ֹ߼��� salay/10000 �� �÷��� ����

-- �÷����� �ӽ÷� �����ؼ� ������ ���� �ִ�.
select first_name, family_name, salary/10000 as �޿� from employees; -- �÷� �̸��� �����ִ� ������ �޿��� ����

-- �����ִ� ���� ���� ����
select family_name, first_name, salary/10000 as �޿� from employees; -- �÷��� ��ġ�� �����ִ� ������ �ٸ�

-- ���ڿ��� ��ĥ ���� �ִ�.
select 
	concat(family_name, first_name) as �̸�,
	concat(truncate(salary/10000,0),'����') as �޿� 
from employees; 
-- concat�� ���ؼ� ���̱� (������ Ÿ�� ���ڿ� ����)
-- truncate(1,2) : 1�� ���� �Ҽ����� 2�� ���� ���̴�.
-- ���ڿ��� �������� �� �̱� ���� : ������ �ٸ� ������ �ν��ع���

select * from employees;
-- ���� ���� �۾��� ������ ���� �����Ϳ��� ���������� ����.
-- �� ���� ���� �����͸� �����ؼ� ������ ������ ���� ���� �ʴ´�.

-- 2) Ư�� ������ �����͸� ��ȸ
-- SELECT [��ȸ�� �÷�] FROM [���̺�] WHERE [����]
-- �达�� ���	
select * from employees where family_name = '��'; -- DB�� ������ ���� ==�� �ƴ� = �Ѱ��� ���� ǥ��

-- ���� 300���� �̻� ���
select  * from employees where salary >= 3000000;

-- && : AND
-- salary > = 1000000 && salary <= 3000000;
select  * from employees where salary >= 1000000 and salary <= 3000000;

-- || : OR
-- family_name == '��' || salary = 2000000;
select  * from employees where family_name = '��' OR salary = 2000000;

-- BETWEEN AND (Ư���� ���̸� ���Ҷ� ���)
-- AND ������ �̿��ؼ� salary �� 50���� ���� ũ�ų� ����, 400���� ���� �۰ų� ���� ����� first_name, fimaily_name, salary �� ���Ͻÿ�.
select  first_name , family_name, salary from employees where salary >= 500000 and salary <= 4000000;
-- �ε�ȣ�� Ư�����ڷ� �νĵǴ� ��찡 �־ ���ϰ��� �Ҷ� ���� ���ȴ�.
select  first_name , family_name, salary from employees where salary between 500000 and 4000000;
-- between A AND B : A�� B ����

-- 3) �ߺ� ����
-- SELECT DISTINCT [����� �÷�] FROM [���̺�]
select family_name from employees where salary = 2000000;
-- distinct �� �ϳ��� �÷��� ����� �� ���� ��Ȯ�� ȿ���� ��Ÿ����.
select distinct family_name from employees where salary = 2000000;

-- 4) IN(OR�ϰ� �Ȱ���.)
-- family_name �� '��' �Ǵ� '��' �Ǵ� '��' �� ����� ��� ������ �����Ͷ�
select * from employees where family_name = '��' OR family_name = '��' or family_name = '��';
-- or �� ���ϴ� �÷��� ��� ���� ��� ����Ѵ�. (�ӵ��� �ξ� ������. : ������ �� ������ ������ ���̰� Ȯ����)
select * from employees where family_name in ('��', '��','��');

-- 5) IS NULL || IS NOT NULL;
-- commision �� 10 �� �༮�� ã�Ƽ� null�� ������
update employees set commision = null where commision = 10;

select * from employees where commision is null;
select * from employees where commision is not null;

-- 6) LIKE 
-- �Ϻ� ����� ���ڿ��� �˻� - �˻� ����� ����Ҷ� ���� ���� ��� (������ ���� ���� �� ��� - ���� ��� ���� �˻� ����)
-- WHERE [�÷���] LIKE '%[���ڿ�]%'
-- ������ ��� �ӵ� ���ϰ� ���ϴ�.

-- ze% 			: ze �� ���������� �ڿ��� �ƹ��ų� �͵� �ȴ�.				-> ze �� �����ϴ�...
-- %com 		: �տ� �ƹ��ų� �͵� ������ �ڴ� com ���� ������ �Ѵ�.	-> com ���� ������...
-- %se%		: se �� �ڿ� �ƹ��ų� �͵� �ȴ�.							-> se�� �����ϴ�...
-- %s%e%	: s �� e ���̿� �ƹ��ų� �͵� �ȴ�.							-> s �Ǵ� e�� �����ϴ�...

select * from employees where email like 'ze%';
select * from employees where email like '%com';
select * from employees where email like '%se%'; -- ���� �߿�
select * from employees where email like '%s%e%';

-- 7) ORDER BY(����)
-- Ư�� �÷��� �������� ����
-- ��������(��) ASC | ��������(��)DESC
-- SELECT * FROM [���̺��] ORDER BY [�÷���] [ASC|DESC];
select * from employees order by salary desc ;
select * from employees order by family_name asc ;
select * from employees order by family_name ; -- asc �� ������ �����ϴ�.

-- �达 �߿��� �޿��� ���� ������ �����ϼ���
select * from employees where family_name = '��' order by salary desc;	-- ������ ���� ���������� ���� �Ѵ�.
-- ������ ���� ������ �����ϼ���.
select concat(family_name, first_name) as name, email , salary*12 as ann_sal from employees order by ann_sal desc;
-- ��������(1�� ���� ��, ������ �����Ϳ��� 2�� ������ ����)
select * from employees order by family_name, salary desc;


-- 8) GROUP BY
-- �����͸� Ư�� �÷��� �������� ��� �������� ��� ���(���)
-- SELECT [�÷�1], [�÷�2], ... FROM [���̺��̸�] GROUP BY [������ �÷�];
-- ��ȸ�Ǵ� �÷����� �����ִ� ���� �÷��̰ų�, ����Ǵ� �÷��̾�� �Ѵ�.

-- �μ����� �޿� �ջ�
select depart_no, truncate(salary/10000,0) from employees order by depart_no;
-- 10389����, 560����, 650����, 2520����, 770���� �� ó�� �ϸ� �ϳ��� �˾Ƽ� ���

select depart_no, sum(salary) from employees where depart_no = 'dev001';
select depart_no, sum(salary) from employees where depart_no = 'dev002';
select depart_no, sum(salary) from employees where depart_no = 'dev003';
select depart_no, sum(salary) from employees where depart_no = 'dev004';
select depart_no, sum(salary) from employees where depart_no = 'dev005';

-- �� ������ group by�� ��ȯ
select depart_no, sum(salary) from employees group by depart_no;

-- �׷��� ������ �Ǵ� �÷���, ���� �÷� ���� �ٸ� �÷��� ���ٸ�?
-- ������ ������ �� �ǹ̸� �� �� ����. -> �� �׷��� ���� ù ���� �����ش�.
-- �ٸ� DB ������ �� ��� ������ �߻���ų���� �ִ�.
select depart_no, sum(salary), family_name from employees group by depart_no;

-- �μ��� �޿� ��� - AVG(column)
select depart_no, truncate(avg(salary),0) as sal_avg from employees group by depart_no;

-- HAVING
-- GROUP BY ���� WHERE ó�� ������ �ְ� ���� �� ��� ( WHERE ��� �Ұ�)
-- having �� ��Ī�� ����ϸ� �ȵȴ�.(total ��� sum(salary)�� ��� �Ѵ�.)
-- �����ƿ����� ��� �� ������ ��� DB������ ������ �߻��Ѵ�.
select depart_no, sum(salary) as total 
	from employees group by depart_no having total > 5000000;

select depart_no, sum(salary) as total 
	from employees group by depart_no having sum(salary) > 5000000;

-- �޿� �հ谡 500���� �̻��� �μ����� �հ� �޿��� ���� ������ �����ϼ���.
select depart_no, sum(salary) as total 
	from employees group by depart_no having sum(salary) >= 5000000 order by total desc;
