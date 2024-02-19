-- auto_increment �� �ڵ� �����ϴ� '�Ӽ�'
-- �ߺ����� �ʰ�, �ݵ�� ���� ���̺� �������̹Ƿ� PK �� ���� ���ȴ�.
-- ������ 1 : ���̺� ������ �Բ� ����
create table auto_inc(
	no int (10) primary key auto_increment
	,name varchar(10) not null
);
desc auto_inc;

insert into auto_inc (name) values ('kim');
insert into auto_inc (name) values ('lee');
insert into auto_inc (name) values ('park');

select  * from auto_inc;

-- ������ 2 : �̹� ������ ���̺� �߰�
create table test(
	no int(10)
	,name varchar(10) not null
);

insert into test (no, name) values(1,'a');

-- auto_increment �� �ش� �÷��� Ű�� �����Ǿ� �־�߸� �Ѵ�.
alter table test modify no int(10) primary key auto_increment;

insert into test (name) values ('b'); -- 2
insert into test (name) values ('c'); -- 3

select * from test;

-- �Ӽ� �ʱ�ȭ
alter table test auto_increment = 100;
insert into test (name) values ('d'); -- 100
insert into test (name) values ('e'); -- 101



