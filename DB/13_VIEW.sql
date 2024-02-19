-- 1) ��
-- ���� ���̺��� �����͸� ��Ƽ� ���� ���� ���̺��̴�.
-- ������ ���������� ������ �ʿ��� �������� �ѹ��� ����ؼ� �並 ����� ������ ���� ���ϰ� ��� �� �� �ִ�.
-- ��� �ڽŸ��� �ε����� ���� �� ����.
-- �信 �ε����� �ְ� �ʹٸ� �÷��� ���� ���̺��� �ε����� �־�� �Ѵ�.

-- 2) �� ���� ����
-- CRAETE [OR REPLACE] VIEW [���̸�] AS [�並 ������ ����];
-- OR REPLACE : ���� �並 �����Ҷ� ����Ѵ�. (OR REPLACE�� ���� �ʰ� ���� �̸��� ���� ��� ���ذ���.)
-- view�� �����ְ� �����Ÿ� �����Ѵٴ� �����̱� ������ ���� * ó�������ʴ´�.

create view name_query as 
	select e.ename, d.deptname from emp e join de	pt d
		on e.deptno = d.deptno; -- �����
	
-- 3) �� Ȯ��
-- show create view [���̸�]; -- ���� ������ ������
show create view name_query;
show full tables where table_type = 'VIEW'; -- �׸� ������
-- 4) �� ��� : ���̺� ���� ����
select * from name_query;

-- �信�� ������ ���ϸ� ���� ���̺��� �����͵� �����ȴ�.
update name_query set ename = 'oh' where ename = 'Kim';
select * from  emp;
-- Kim �� �����ִ� ������ 6���� ��� ������� ���ǿ� ���� �ʾ� �信 ���Ե��� �ʾұ� ������ �信�� ���������� ������ ���� �ʾҴ�.

-- 5) �� ����
-- ALTER�� ���� ���������� �Ϲ������� OR REPLACE �� ����Ѵ�. (������ ����, ������ �����)
-- ������ �����ϰ�, ������ ����� ������
create or replace view name_query as 
	select e.ename, d.deptname, d.loc from emp e join dept d on e.deptno = d.deptno;

select * from name_query;

-- 6) WITH CHECK OPTION : �並 ������ ���ǽ��� �����ϴ� �÷��� ���ؼ��� ������ ���� �ɼ�
create view chk_option as select ename, job, deptno from emp where deptno = 1 with check option;
select * from chk_option;
-- �Ϲ����� ������ ��� �����ϴ�.
update chk_option set job = 'manager' where ename = 'lee';

-- �並 ���� ������ deptno �� ���� �Ұ����ϴ�.
update chk_option set deptno = '2' where ename = 'lee';

-- �������ְ� �ʹٸ� ���� ���̺��� �����ؾ� �Ѵ�.
update emp set deptno = '2' where ename = 'lee' and job = 'manager';
select * from emp;

-- 7) �� ����
-- DROP VIEW [���̸�]
drop view chk_option;
drop view name_query;

show full tables where table_type='VIEW';
