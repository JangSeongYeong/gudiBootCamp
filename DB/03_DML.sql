/*DML(Data Manipulation Language)
 * �����͸� �ٷ�� ���(SELECT, INSERT, UPDATE, DELETE, UPSERT)
 */

-- employees ���̺� ������ Ȯ��
select * from employees;

-- 1. ������ ����
-- INSERT INTO [���̺��](�÷���,...)VALUES(�÷��� ���� ��,...);
insert into employees(emp_no, first_name, family_name, email, mobile, salary, depart_no, commision)
	values(111,'����','��','zxz0608@naver.com','01012341234',99999999,'dev01',90);
	
insert into employees(
	emp_no, 
	first_name, 
	family_name, 
	email, 
	mobile, 
	salary
)values(
	112,
	'�±�',
	'��',
	'email@naver.com',
	'01043214321',
	9999999
);

insert into employees(
	emp_no, 
	family_name, 
	email, 
	mobile, 
	salary
)values(
	113,
	'��',
	'email@naver.com',
	'01043214321',
	99999999
);

-- 2. ������ ����
-- DELETE FROM [���̺��] WHERE [����];
-- delete from employees; -- ���̺��� �����ȴ�.
-- commision �� null �� ���� ��������
delete from employees where commision is null;

-- 3. ������ ����
-- UPDATE [���̺��] SET [�÷�] = [��] WHERE [����];
-- depart_no �� dev005 �� row �� ���ؼ� commision �� 30 ���� ����
update employees set commision = 30 where depart_no = 'dev005';

-- ����, ������ where ����

-- employees ���̺� ������ Ȯ��
select * from employees;



