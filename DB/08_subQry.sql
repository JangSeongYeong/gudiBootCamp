-- ���� ���� : ���� ���� ����
-- �ϳ��� ���������� �޾ƿ� �����͸� �������� �ٸ� ������ �˻��� ��
-- 1. ����� ����� �ٸ� ������ �˻���
-- 2. �˻��� ������ ������ �÷����� ����

--  ���������� ������� �� ������ �Ϻη� ���� ��� - �÷�, ���̺�� Ȱ���� �ȴ�. (�߿�)

create table dept( -- �μ�
	deptno varchar(10) primary key
	, deptname varchar(20)
	, loc varchar(10)
);

create table emp( -- ���
	ename varchar(20)
	, job varchar(50)
	, deptno varchar(10)
	, hiredate date
);

alter table emp add constraint foreign key(deptno) references dept(deptno);

insert into dept(deptno, deptname, loc) values('1','sales','newyork');
insert into dept(deptno, deptname, loc) values('2','dev01','la');
insert into dept(deptno, deptname, loc) values('3','personnel','newyork');
insert into dept(deptno, deptname, loc) values('4','delevery','boston');

insert into emp(ename, job, deptno, hiredate) 
	values('kim', 'manager', '1', str_to_date('16/01/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('lee', 'staff', '1', str_to_date('15/01/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('han', 'staff', '1', str_to_date('16/03/02','%Y/%m/%d'));	
insert into emp(ename, job, deptno, hiredate) 
	values('kim', 'assistant', '1', str_to_date('15/09/22','%Y/%m/%d'));

insert into emp(ename, job, deptno, hiredate) 
	values('ahn', 'staff', '2', str_to_date('15/11/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('hwang', 'manager', '2', str_to_date('15/08/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('cha', 'assistant', '2', str_to_date('12/03/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('hong', 'staff', '2', str_to_date('14/08/02','%Y/%m/%d'));
insert into emp(ename, job, deptno, hiredate) 
	values('gang', 'staff', '2', str_to_date('10/01/02','%Y/%m/%d'));

insert into emp(ename, job, deptno, hiredate) 
	values('name', 'leader', '4', str_to_date('10/01/02','%Y/%m/%d'));


-- ����1> 'han' �� �ٹ� �μ���?
-- emp ���̺��� han �� deptno �� �˾Ƴ���.
select deptno from emp where ename = 'han'; -- 1
-- deptno �� ���� dept �� deptname �� �˾Ƴ���.
select deptname from dept where deptno = '1';
-- �ذ�
select deptname, loc from dept where deptno = (select deptno from emp where ename = 'han');

-- ����2> �μ� ��ġ�� 'la' �Ǵ� 'boston'�� �μ� �Ҽ��� ����鿡 �̸� ,��å��?
-- ��ġ�� ���� �μ� ��ȣ
select deptno from dept where loc in('boston', 'la'); -- 2, 4
-- �μ� ��ȣ�� �´� ����� ��å
select ename, job from emp where deptno in('2', '4');
-- �ذ�
select ename, job from emp where deptno in((select deptno from dept where loc in('boston', 'la')));
-- �ɽ��ؼ� �� OR�� ��� ����
select ename, job from emp where deptno =(select deptno from dept where loc ='boston') OR deptno =(select deptno from dept where loc ='la');

-- ���� 3> salse �μ��� �ٹ��ϴ� ��� ������(ename, job, hiredate) ��������
-- salse�� �μ� ��ȣ
select deptno from dept where deptname = 'sales'; -- 1
-- salse ��� ������(ename, job, hiredate)
select ename, job, hiredate from emp where deptno = '1';
-- �ذ�
select ename, job, hiredate from emp where deptno = (select deptno from dept where deptname = 'sales');

-- ���� 4> ��å(job)�� manger �� �����(�������� ��� ���� ���� ����)���� �Ի����� ���� ������(ename, job, hiredate)��?
-- �Ŵ��� ���� �� ���� �Ի��� ���� ����
select * from emp where job = 'manager' order by hiredate; -- �� �� �������� ���� ������ 2015-08-12
-- �Ŵ��� �� ���� ���� �Ի��� �λ�� �� ��
select ename, job, hiredate from emp where hiredate < '2015-08-12' order by hiredate; 
-- �ذ� 1>
select ename, job, hiredate from emp 
	where hiredate < (select hiredate from emp where job = 'manager' order by hiredate limit 1) 
	order by hiredate; -- limit n : ���� ������ �� n
-- �ذ� 2>
select ename, job, hiredate from emp 
	where hiredate < (select min(hiredate) from emp where job = 'manager') order by hiredate;

-- ���� 5> �μ���(deptno, deptname)�� ������ ������� Ȯ��
-- deptno �׷�ȭ �� ������ ���� ����
select deptno, count(deptno) as scnt  from emp group by deptno; -- count(*) : ��ȸ�Ǵ� �������� ����

select count(deptno) from emp where deptno = 1; -- 4
select count(deptno) from emp where deptno = 2; -- 5
select count(deptno) from emp where deptno = 4; -- 1

select deptno, deptname from dept where deptno = 1;
select deptno, deptname from dept where deptno = 2;
select deptno, deptname from dept where deptno = 4;

-- ���� ���� ����
-- ���������� ������� �� ������ �Ϻη� ���� ���
-- �÷�, ���̺�� Ȱ���� �ȴ�. (�߿�)
select deptno, deptname, (select count(deptno) from emp where deptno = 1) as cnt from dept where deptno = 1;
select deptno, deptname, (select count(deptno) from emp where deptno = 2) as cnt from dept where deptno = 2;
select deptno, deptname, (select count(deptno) from emp where deptno = 4) as cnt from dept where deptno = 4;

-- �ذ�>
select deptno, deptname, (select count(deptno) from emp where deptno = d.deptno) as cnt 
	from dept d; -- dept d  �Ǵ� dept as d : ��Ī (���� ���� ������ ���밡��)

-- �ذ�2> group by ���
select deptno
	,(select deptname from dept where deptno = emp.deptno) as deptname
	,count(deptno) as cnt
	from emp group by deptno; -- group by���� ī��Ʈ�� ���� ģ���� count X


