-- 1) PRIMARY KEY (�⺻Ű ��������)
-- �ߺ��� NULL �� ������� �ʴ´�.
-- ���̺� �������̴�. (�ϳ��� ���̺� �ϳ��� PK)
-- �ϳ��� �÷����� �ϳ��� PK �� ���� �� ������, �������� �÷��� ���ļ� ���� ���� �ִ�.(�ִ� 16�� ���� ���� ����)

-- ���̺� ������ �Բ� ����(���� ���� Ȱ��)
create table pk_test(
	first_col int(3) primary key,
	second_col varchar(4)
);
desc pk_test; -- PRI �� �ִٸ� ����� �� ��

-- ���̺� ���� �� �߰�
desc employees;
-- ALTER TABLE [���̺� ��] ADD CONSTRAINT [�������� Ÿ��](�����ʵ�);
alter table employees add constraint primary key(emp_no);
alter table employees add primary key(emp_no);

-- �Ϻη� �ߺ� ������ �־��
select * from employees order by emp_no;
-- SQL Error [1062] [23000]: (conn=56) Duplicate entry '119' for key 'PRIMARY'
insert into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(119,'���','��','search@daum.net','01012341234',45000000);

-- UPSERT - �ߺ��Ǵ� Ű���� ������ ����, ������ ����
insert into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(112,'�±�','��','search@daum.net','01012341234',45000000)
on duplicate key update email = 'email@naver.com', salary=99999999;

select @@autocommit;

-- ����Ű(combination key)
-- �ϳ��� �÷����� �ϳ��� �⺻Ű�� �����ϴ� ���� ���� ������, ��¿�� ���� ��� �ټ��� �÷��� �����ؼ� �⺻Ű�� ����
-- �ִ� 16�� ����
-- �ܷ�Ű�� �̿��� ����Ű�� ����� ��찡 �ִµ�, �̰�� UPDATE �� INSERT �� ������ �ֹǷ� ������� �ʴ� ���� ����.
create table pk_tow_test(
	first_col int(5),
	second_col varchar(10),
	third_col date,
	primary key(first_col, second_col)
);
desc pk_tow_test;

-- 2) NOT NULL (NULL �� ������� ����)
-- NOT NULL �� ���� ���������� �Ӽ����� ���
-- �⺻������ �����ϸ鼭 �ִ´�. ex) first_col int(5) not null,
-- ���̺� ���� �� NOT NULL �ֱ�
-- ALTER TABLE [���̺��] MODIFY [�÷���] (������);
ALTER TABLE pk_test modify second_col varchar(4) not null;
desc pk_test;

-- �������� Ȯ��
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'pk_tow_test';
-- ���� ���� ����
-- ALTER TABLE [���̺�] DROP [�������� ����];
alter table pk_tow_test drop primary key;