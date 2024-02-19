-- JOIN �̶�?
-- �� �̻��� ���̺��� �����Ͽ� �����͸� �˻��ϴ� ����̴�.
-- �� ���� ���̺��� �����ϱ� ���ؼ��� ��� �ϳ��� ����� �÷��� �����ؾ� �Ѵ�.
-- �׷��� �Ϲ������� �θ�(PK)�� �ڽ�(FK)���� ������ �����ϰ� �̷�� ����.

-- JOIN �� ���� *EQUI JOIN, OUTER JOIN�� ���� �߿�
-- CROSS JOIN, EQUI JOIN(�����, ��������)
-- NON-EQUI JOIN(���� �Ⱦ��̱� ������ �ٷ��� ����)
-- SLEF JOIN, OUTER JOIN

-- 0. CROSS JOIN
-- �ΰ��� ���̺��� ī�ٽþ� ���� �����Ѵ�. (��� ����� ���� �� ��)
-- emo(10) * dept(4) = 40

-- FROM[tableA] CROSS JOIN [tableB];
select e.ename, d.deptname from emp e cross join dept d;
-- cross join �� ���� ���� ,�� ����
select e.ename, d.deptname from emp e, dept d;

-- cross join �� ���� �������� ���� ������ ���� ����
-- �׷��� ������ �־ ���ϴ� �����͸� �̾Ƴ���.


-- 1. Equi Join - ���� �ϴ� �� ���̺� ��ο� ���� ���� ���� �����ش�.
-- ���� �Ϲ������� ����ϴ� ����(= �� ���)

-- 1) � ����
select e.ename, d.deptname from emp e, dept d where d.deptno = e.deptno;

insert into dept(deptno, deptname, loc) values('5','dev02','florida');

/* ���ʿ� ������ �ұ����� ���� ���
 * ename, deptname
 * [NULL], personnel
 * [NULL], dev02
 * �̷������� �������� ����
 */

-- 2) ���� ���� ON, using
-- FROM [tableA] INNER JOIN [tableB]
-- inner�� ���� ����, ������ ���� ������ where �� �ƴ� on�� ���
select e.ename, d.deptname from emp e join dept d on d.deptno = e.deptno;
-- using �� ����Ͽ� ������ �� �� �ִ�.
-- using(��������) �� �����ϴ�.
select e.ename, d.deptname from emp e join dept d using (deptno);

-- <��õ> on���� ó���ϰ� �������� where�� �ϴ� ���� ��õ��

-- 3) ���� ����
-- ���� ������ �� ���̺� ���� ����Ǵ� �÷��� ������ �ڿ������� �������� �ȴ�.
-- �׷��� ������ ���� �������� �ʿ� ����.
-- ���� ���� : ����Ǵ� �÷����� ������� ������� �ʴ´�. (�Ϻ� DB���� ���� �� �� ���� // �������� ��)
select e.ename, d.deptname from emp e natural join dept d;


-- 2. ��������
-- Equi-Join �� �Ȱ���. �ٸ� �� ���� ���̺��� �� �� �ڽ��̶�� �͸� �ٸ���.
-- ���������� �ϸ� �� �����Ͱ� ī�ٽþ� ���� �����Ѵ�.
select a.ename, b.job from emp a, emp b where a.deptno = b.deptno;


-- 3. �ܺ����� 
-- [tableA] [left | right] outer join [tableB] ON ������
-- LEFT (������ �������� �� �ִ� ���� ������) - ���⼭ ���� deptno 1,2,3,4,5 | deptno 1,2,4 �� ���� ���� ������ �ǹ��Ѵ�.
-- RIGHT (�������� �������� �� �ִ� ���� ������)
-- FULL (���� ���� ���� ������)  -- Maria DB ���� X
-- outer�� ���� ����
select e.deptno, e.ename, d.deptname 
	from emp e  right outer join dept d on e.deptno = d.deptno; -- ���� ������ ���� ���� �����ϴ°� �Ϲ����̴�.(������ ���°� ���εƴٸ� NULL ǥ��)

-- emp �� deptno 6���� �߰�
insert into emp(deptno, ename, job, hiredate) values ('6', 'kim', 'assistant', str_to_date('14-06-02','%Y-%m-%d'));
-- ���� ���� ���Ἲ ���� ���ǿ� ���ؼ� �θ�(dept) ���� ���� 6���� �ڽ�(emp)�� ���� �� ����.
-- �׷��� �θ�-�ڽ� ���踦 ���� -> FK �� ����
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'emp';
-- alter table [�ڽ����̺�] drop constraint [��������];
alter table emp drop constraint emp_ibfk_1;

select e.deptno, e.ename, d.deptname 
	from emp e  left outer join dept d on e.deptno = d.deptno;

/* left join : join �� �������� ���� ���̺��� �����͸� �������� �����ش�.(�����ʿ� ���� ������ null ó��) - 1, 2, 4, 6
 * right join : join �� �������� ������ ���̺��� �����͸� �������� �����ش�.(���ʿ� ���� ������ null ó��) - 1, 2, 3, 4, 5
 * full outer join : ���� ���� ������ ������ �� �ִ� ��� (Mariadb ���� X)
 * */



