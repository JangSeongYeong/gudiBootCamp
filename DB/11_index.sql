-- �ε���(����) : �˻��� ������ ���ֱ� ���� ���
-- ��) ������ ������ �� �ܾ��� ��ġ�� �˷��ִ� ���
-- �׷��� ���� �ܾ �߰�/���� �� �� �ε����� �߰�/���� ���־�� �Ѵ�.

-- 1) ���� �ε���(UNIQUE INDEX)
-- �ߺ����� �ʴ� �����Ϳ� ���ؼ��� �����Ǵ� �ε���
-- PK �� ����ũŰ�� �ɾ��ָ� �ڵ����� �����Ǵ� �ε���
-- �ε��� ������ �ߺ������Ͱ� ������ ���� �߻�
-- CREATE UNIQUE INDEX [�ε��� �̸�] ON [���̺��] (�÷�);
create unique index emp_ename_idx on emp(ename);
select * from emp;

-- 2) ����� �ε���(NON UNIQUE INDEX)
-- FK ������ �� �ε����� �ɷ� �ִ�.
-- �ߺ� �����Ͱ� �־ �ε��� ������ ����
-- CREATE INDEX [�ε��� �̸�] ON [���̺��] (�÷�);
create index emp_ename_idx on emp(ename);

-- 3) ����(����) �ε��� 	
-- ����Űó�� ���� �÷��� �����ؼ� �ε��� ������ ����(16�� ���� ����)
-- CREATE [UNIQUE] INDEX [�ε��� �̸�] ON [���̺��] (�÷�, ...);
create unique index emp_combi_idx on emp(ename, job, deptno);

-- 4) �ε��� Ȯ�� ���
-- show index from [���̺��]
show index from emp;

-- 5) �ε��� ����
-- �ε����� ���̺� �Ӽ����� ���
-- ALTER TABLE [���̺��] DROP INDEX [�ε����̸�];
alter table emp drop index emp_ename_idx;
