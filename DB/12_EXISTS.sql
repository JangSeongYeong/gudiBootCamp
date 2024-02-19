/*IN & EXISTS*/
-- �μ��� LA �Ǵ� BOSTON �� �ִ� ������ �̸��� ��å
select ename, job from emp where deptno in(select deptno from dept where loc in('la','boston'));

-- 1. IN : '=' �񱳸� ����(ũ��, �۴� �� �ȵ�), OR ������ �˻� ��� ������ �����´�. , "���� �÷����� �������� ���ϸ��� ��"�ϴ� OR ������ ��� ���
-- ���������� ���� ����ǰ� �� ����� ������ ���� ������ �����Ѵ�.

-- 2. EXISTS : ���������� �� ������ ���������� ��� �߿��� '�����ϴ� ���� �ϳ��� �����Ѵٸ�' ��(1)/����(0)���� ��ȯ
-- ���������� ���� ����ǰ�, ���� ���������� ����ȴ�. (�߿�1)
select exists (select deptno from dept where loc = 'la' or loc = 'boston') as bool;

-- �������� ���� �� �����͸� exists ������ ���� �Ǹ� ��� ������ �����ְ�
select ename, job, deptno from emp 
	where exists (select deptno from dept where loc = 'la' or loc = 'boston');

select * from emp where 1;

-- ���� �ƴ϶�� �ƹ��͵� �������� �ʴ´�.
select ename, job, deptno from emp 
	where exists (select deptno from dept where loc = 'korea');

select * from emp where 0;

-- �� Ư���� ������ ��� ����� ���ΰ�?
-- 1) ���������� ����Ǿ� �����͸� Ȯ���ϰ�
select ename, job, deptno from emp;

-- 2) Ȯ���� �����ͷκ��� dept �� ���� �� �ش�.
-- ���� �� �� �ִ� �����͸� ������
-- �Ʊ� ���� �� ��� �����͸� �������� �ʾҴ°�? (6���� �Ⱥ�����)
-- ���� ������ �������� ���� ����� �÷��� �������� �ɰ� �־ (���������� �������� ���� ����Ǿ� �ִ�.)
select ename, job, deptno
	from emp e where exists (select deptno from dept d where e.deptno = d.deptno);

-- 3) �ɷ��� �༮�� �߿��� dept ���� loc �� la �̰ų� boston �� �༮�� ��󳻸� �ȴ�.
select ename, job, deptno
	from emp e where exists (
		select deptno from dept d where e.deptno = d.deptno and (d.loc = 'boston' or d.loc = 'la')
	);

select ename, job from emp where deptno in(select deptno from dept where loc in('la','boston')); -- �̰� ���� ����

/* IN �� EXISTS ���� ����� ������ �ӵ��� ������.
 * SQL ������ �����͸� Ȯ���� ���� �����۾��� �����ϴ� ���� ������ �����̴�.
 * EXISTS �� ���������� ���� �����͸� Ȯ���ϰ�, �������� �������� ��ġ�ϴ� ������ �����ֱ� ������ �ӵ��� �� ������.
 * -- �����Ͱ� �ִ��� ������ Ȯ���ϴ� ������ε� ����Ѵ� (EXISTS)
 * */
-- �ϳ��� �۾��� ���� �س��� �ٸ� �۾��� �ϴ°� �ӵ��� ������. (�߿� 2)


/*ANY & ALL*/
-- 3. ANY : ���� ������ �������� ���������� ����߿� �ϳ��� ��ġ�ϸ� ��.
-- IN ó�� �� ���� �ְ�, ũ��/�۴ٸ� Ȱ���� �� �ִ�.
-- 1) = ANY : IN �� ���� ȿ��
select ename, job from emp where deptno in (select deptno from dept where loc in('la','boston')); 
select ename, job from emp where deptno = any (select deptno from dept where loc in('la','boston')); 

-- ��å�� manager �� ������ �Ի����� ���� ���� �������, �ʰ� �Ի��� ����� ��å�� �Ի�����
select job, hiredate from emp where hiredate > (select min(hiredate) from emp where job = 'manager') order by hiredate;
-- 2) > ANY : �ּҰ� ���� ũ��
select job, hiredate from emp where hiredate > any (select hiredate from emp where job = 'manager') order by hiredate;


-- ��å�� manager �� ������ �Ի����� ���� ���� �������, ���� �Ի��� ����� ��å�� �Ի�����
select job, hiredate from emp where hiredate < (select max(hiredate) from emp where job = 'manager') order by hiredate;
-- 3) < ANY : �ִ밪 ���� ������
select job, hiredate from emp where hiredate < any (select hiredate from emp where job = 'manager') order by hiredate;

-- 4. ALL : ANY �� �ݴ�
-- 1) = ALL : = ANY �� ������ AND �����̴�.
select ename, job from emp where deptno = all(select deptno from dept where loc = 'boston');
-- ���� ���� ���� ���� �������� ��Ÿ�� ��� ����ϸ� �ȵȴ�.

-- 2) > ALL : �ִ밪 ���� ũ��
-- ��å manager �� ������ �Ի����� ���� ���� �������, �� �ʰ� �Ի��� ����� ��å�� �Ի�����
select job, hiredate from emp where hiredate > (select max(hiredate) from emp where job = 'manager') order by hiredate;
select job, hiredate from emp where hiredate > all (select hiredate from emp where job = 'manager') order by hiredate;

-- 3) < ALL : �ּҰ����� ������
-- ��å manager �� ������ �Ի����� ���� ���� �������, �� ���� �Ի��� ����� ��å�� �Ի�����
select job, hiredate from emp where hiredate < (select min(hiredate) from emp where job = 'manager') order by hiredate;
select job, hiredate from emp where hiredate < all (select hiredate from emp where job = 'manager') order by hiredate;


