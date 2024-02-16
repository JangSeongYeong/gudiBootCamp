-- transaction -> TX

-- 1) AUTO COMMIT ����
-- �ֿ� �۾��� �ϰԵȴٸ� ���� 0���� Ȯ�� 
-- �����ų� �Ǽ����� ��� �ٷ� Ȯ�� (��������)
select @@autocommit; -- 1: ����, 0: �̼���

-- ���� | �̼���
set autocommit = 1; -- ����Ŀ�� ���� ON
set autocommit = 0; -- ����Ŀ�� ���� OFF

-- commit �� rollback �� ������(DML)�� �����ȴ�.
-- DCL, DDL �� �ǵ��� �� ����.

-- ���� ���� �����ϴ� ���� commit;
select * from employees;
update employees set commision = 10 where emp_no = 129;
commit;

delete from employees;
-- rollback : commit ���� ���� ���뿡 ���ؼ� �ǵ��� �� �ִ�.
rollback;

