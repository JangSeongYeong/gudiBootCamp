-- RDBMS (Relation Data Base Management System)
-- ������ ������ ���̽�

-- 1. ���� ���� ���� (�ܷ�Ű ��������)
-- 1) ���̺� ������ �߰�
create table parent_table(
	user_id varchar(30) primary key,
	user_name varchar(20),
	user_phone varchar(20),
	user_addr varchar(100)
);

-- �θ��� �⺻Ű�� �ܺο��� ������ �´�. -> �ܷ�Ű ��������
create table child_table(
	order_id int(10)
	,user_id varchar(30) -- ������ ,�� ���θ� ����� ������ �� ,���� ����� ������ ���� �� �ִ�. 
	,product_name varchar(30)
	,price varchar(30)
	,qty varchar(30)
-- 	, foreign key(user_id) references parent_table(user_id)
);

-- 2) ���̺� ���� �� �߰�
-- ALTER TABLE [���̺� ��] ADD CONSTRAINT [������������](�����ʵ�) REFERENCES [������ ���̺�](������ �÷�)
alter table child_table add constraint foreign key(user_id) references parent_table(user_id);

select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'child_table';

/* �θ��ڽ� ����� �θ��� �⺻Ű�� �ڽ��� ������ ���� �����̴�.
 * �̶� �θ��� �⺻Ű�� ���� �⺻Ű�� ����ϴ� ��츦 '�ĺ� ����' ��� �Ѵ�.
 * �׷��� ���� ���� '��ĺ� ����'��� �Ѵ�.
 */

-- �ĺ� ���� (�Ϻ��� 1�� 1���迡�� ����ؾ� �Ѵ�.)
create table iden_table(
	user_id varchar(30) primary key,
	foreign key(user_id) references parent_table(user_id)
);


-- 2. ���� ���� ���Ἲ ��������
-- �θ��ڽİ��� �������� �յ� ���� �¾ƾ� �Ѵ�.

-- ��� �÷��� ���� ���� ��� �÷����� �����ص� �ȴ�. (���� ������ �ƴϴ� - �ڵ�� �ٸ������ �����ϱ� ������)
insert into parent_table values('user01','��ö��','01012341234','���� ��õ��');
insert into parent_table values('user02','ȫ�浿','01012341234','���� ��õ��');
insert into parent_table values('user03','�ڿ���','01012341234','���� ��õ��');
select * from parent_table;

insert into child_table values(1, 'user01', '�Ƿ�', 6000, 1);
insert into child_table values(2, 'user02', '�Ƿ�', 6000, 1);
insert into child_table values(3, 'user03', '�Ƿ�', 6000, 1);
select * from child_table;

-- �θ����� ���� ���� �ܷ�Ű�� �������� �ϸ� ������ ��Ÿ����.
-- ���� ���� ���Ἲ�� ������.
-- �θ� ���̺��� �⺻Ű�� user04�� ������ �ڽ��� �װ��� ������ �ߴ�. -> �θ���� �ڽ��� ������� ��
-- SQL Error [1452] [23000]: (conn=58) Cannot add or update a child row
insert into child_table values(4,'user04', '�Ƿ�', 6000, 1);

-- �θ� ���� ����
-- SQL Error [1451] [23000]: (conn=58) Cannot add or update a child row:
delete from parent_table where user_id = 'user01';

-- ���� ���� ���Ἲ�� ��ġ�� �ʰ� �����Ϸ��� �ڽ��� ���� �����ǰ�, ���� �θ� �����Ǿ�� �Ѵ�.
-- �� ������ �ڵ����� ������ �ִ� ON DELETE CASCADE �ɼ��� �ִ�. (���̺� �����ÿ��� ���� �� �ִ� �ɼ��̴�. "�߰��� �Ұ���")

create table supplier(
	sup_id int(10) primary key
	,sup_name varchar(50) not null
	,phone varchar(12)
);

create table products(
	pd_id int(10) primary key	
	,sup_id int(10)
	,price int(10)
	, foreign key (sup_id) references supplier (sup_id) on delete cascade
);

insert into supplier values(1,'��ö��','01012341234');
insert into supplier values(2,'��ö��','01012341234');
insert into supplier values(3,'��ö��','01012341234');

insert into products values(1111,1,6000);
insert into products values(1112,2,6000);
insert into products values(1113,3,6000);

select * from supplier;
select * from products;

delete from supplier where sup_id = 1;


-- 3. unique ��������
-- �ߺ��� ������� �ʴ� ��������
-- ���̺� �ټ� ������ �� �ִ�.
-- unique + not null = PK
-- �ĺ�Ű - �⺻Ű�� �� �� �ִ� ����(�ߺ�X, not null)�� ���� �� �����Ƿ�...
-- ALTER TABLE [���̺��] ADD CONSTRAINT [������������](�÷���);
alter table supplier add constraint unique(sup_name);
desc supplier;
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'supplier';

-- Duplicate entry '��ö��' for key 'sup_name' : �̹� ��ö����� sup_name�� �ִ�.
insert into supplier values(4,'��ö��','01012341234');


-- 4. check �������� (��� X)
-- ������ ���� ������ ���� �ʴ� ���� ����
-- ALTER TABLE[���̺��] ADD CONSTRAINT [������������](����)
-- ���� ���� : ������ ���� �����Ͱ� �����ؾ��� ������ �ɾ�� �Ѵ�.

-- price �� 5000�� �̸��� ��츸 �ްڴ�.
alter table products add constraint check(price < 5000); -- �̹� �����Ͱ� 5000�� �Ѿ �Ұ���

-- price �� 6000������ ���� ��츸 �ްڴ�.
alter table products add constraint check(price <= 6000);

insert into products values(1114,2,6000); -- 6000�� ���� ũ�� �ȵ���.

-- �Ⱦ��� ����
-- 1. ������ �������� ��������.
-- 2. ���� ����� DDL �� �����ؾ� �Ѵ�.
-- 3. � ������ �ɷ��ִ��� �ľ��ϱⰡ ���� �ʴ�. (DB �ȿ��� ã�ƾ� ��)
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME  = 'products';







