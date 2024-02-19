-- �ټ��� ���̺��� ���� ���� �� �� �ִ�.
-- ������(UNION, UNION ALL), ������(INTERSECT), ������(MINUS)�� �����Ѵ�.
-- �ߺ� ���Ÿ� ���ִ� UNION �� �������� ������ �������� �ʴ´�. (��ġ�� Ȯ���ϴ°� �ƴ� �ϳ��� Ȯ���ϸ鼭 �ߺ��� Ȯ���ؼ� �������ϰ� �߻��Ѵ�.)
-- [qry1] [UNION | UNION ALL | INTERSECT | MINUS] [qry2]

-- 1. UNION : �ߺ��� ������ ������
select deptno from emp
	union
select deptno from dept order by deptno;

-- left join �� right join �� union �ϸ� full outer join ȿ���� ���� �� �ִ�.
select e.deptno, e.ename, d.deptname from emp e left join dept d on e.deptno = d.deptno
	union
select d.deptno, e.ename, d.deptname from emp e right join dept d on e.deptno = d.deptno order by deptno;


-- 2. UNION ALL : �ߺ����� ���� ������ ����
-- UNION ALL �� �����ϰ� ����Ѵٱ� ���ٴ� �����ؼ� ����Ѵ�.
select deptno from emp
	union ALL
select deptno from dept order by deptno;


-- 3. INTERSECT : �� ���̺� �����ϴ� �ߺ��� �����͸� Ȯ���Ѵ�.
select deptno from emp
	intersect
select deptno from dept order by deptno;


-- 4. MINUS : MariaDB ������ �������� �������� �ʴ´�.
select distinct deptno to from emp; -- 1,2,4,6 
select distinct deptno to from dept; -- 1,2,3,4,5

-- emp - dept = 6
select deptno from emp where deptno not in (select deptno from dept);

-- dept - emp = 3,5
select deptno from dept where deptno not in (select deptno from emp);

-- emp �� dept �� ������ �� ������ emp �� ������
select deptno from emp
	union
select deptno from dept
	intersect
select deptno from emp;

-- union �� ��ü�� ���?
-- 1. �ϴ� ��ģ��.
-- 2. ��ģ ������ ������ �ߺ� ����
select distinct u.deptno from
	(select deptno from emp
		union all
	select deptno from dept) as u
order by u.deptno;
-- �ӵ��� ������ �Ϸ��� ������ �����͸� Ȯ���� �ϰ� �����ؾ� �Ѵ�.