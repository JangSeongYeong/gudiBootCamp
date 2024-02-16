select * from mysql.user;

/*D.D.L(Data Define Language)*/

-- ������ ���̽� ��� ����
show databases;

-- ������ ���̽� ����
-- CREATE DATABASE [������ ���̽� �̸�];
create database mydb;

-- ������ ���̽� ����
-- DROP DATABASE [������ ���̽� �̸�];

-- ������ ���̽� ���
-- USE [������ ���̽� �̸�];
use mydb;

-- ���̺� ��� Ȯ��
show tables;

-- ���̺� ����
-- CREATE TABLE [���̺��](
-- [�÷���] [������Ÿ��](ũ��),
-- ...
-- );

/* ������Ÿ�� ����(���� ���� �Ϻ�)
 * 1) ���� Ÿ��
 * ������ - �� �� ������ ũ�Ⱑ ������ ���� (2���ڷ� ���������� 1���ڷ� ���� ���� �� �ڸ��� ����ó�� ��) -- "�� "�� "��"�� �ٸ���.
 * char(����Ʈ ��)
 * ������ - ������ ũ�⺸�� ���� ������ �˾Ƽ� �ٿ��ش�.
 * varchar(����Ʈ ��)
 * text			: 65,535 byte -- �� ū ����Ʈ
 * longtext		: 4,294,967,295 byte -- ��û ū ����Ʈ
 * 
 * 2) ���� Ÿ�� - int, long, float, double
 * 
 * 3) boolean 
 * 
 * 4) ��¥ Ÿ��
 * DATE				: 0000-00-00
 * DATETIME		: 0000-00-00 00:00:00
 * TIMESTAMP	: DATETIME �� ������ time zone �� ���� �ð��� ���� �ȴ�. (���� ���񽺽ÿ� ���)
 * */

create table test_table(
	user_name varchar(50),
	age int(3),
	mobile varchar(11),
	reg_date date default current_date -- �⺻���� ���� ��¥�� �ִ´�.
);

-- ���̺� ���� ����
-- DESC [���̺� ��]
desc test_table;


-- ���̺��� �Ʒ��� ���� ����� ����
-- ���̺� �� : employees
-- emp_no ������ 3�ڸ�
-- first_name ���ڿ� 8��
-- last_name ���ڿ� 2��
-- email ���ڿ� 50��
-- mobile ���ڿ� 11�� + ���� 2��
-- salary ������ 8��
-- reg_date ��¥ ������� �Էµȴ�.

create table employees (
	emp_no int(3),
	first_name varchar(8),
	last_name varchar(4),
	email varchar(50),
	mobile varchar(13),
	salary int(8),
	reg_date date default current_timestamp
);

desc employees;

show tables;
-- ���̺� ����
-- DROP [���̺� ��]
drop table test_table;


-- CREATE �� ������ �༮�� DROP ���� �����ϰ� ALTER �� �����Ѵ�.
-- ���̺� ����(�÷��� ���� ����)
-- 1) �÷� �̸� ���� (���� �����Ͱ� �����ȴ�.) -- ���� �����Ͱ� ������ �̸��� �Ժη� �ٲٸ� �ȵȴ�.
-- ALTER TABLE [���̺� ��] RENAME COLUMN [������ �̸�] TO [������ �̸�];
ALTER TABLE employees RENAME COLUMN last_name TO family_name;
desc employees;

-- 2) �÷� �߰�
-- ALTER TABLE [���̺� ��] ADD ([�÷���] [������ Ÿ��](ũ��));
ALTER TABLE employees ADD (depart_no varchar(10)); -- depart_no ���ڿ� 10����Ʈ
ALTER TABLE employees ADD (commision varchar(10)); -- commision ���ڿ� 10 ����Ʈ
alter  table employees add (etc varchar(100)); -- etc ���ڿ� 100 ����Ʈ

-- 3) �÷� �Ӽ� ����(�ش� �÷��� ��� �־�� �Ѵ�.)
-- ALTER TABLE [���̺� ��] MODIFY COLUMN [�÷���] [������Ÿ��](ũ��);
ALTER TABLE employees MODIFY COLUMN commision float(4,2); -- float(��ü �ڸ���,�Ҽ��� �ڸ���) -> 00.00
desc employees;

-- 4) �÷� ����
-- ALTER TABLE [���̺� ��] DROP COLUMN [�÷���]
-- etc ���� �� ����
ALTER TABLE employees DROP COLUMN etc;

