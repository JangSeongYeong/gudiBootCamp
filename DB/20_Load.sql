-- ��� ����(dump)�� �����ͺ��̽��� �����ϴ� ���
-- 1. ������ ������ ���̽��� ����(���� ���,,,)
create database employees;
show databases;

-- 2. mariaDB �� ��ġ�Ǿ� �ִ� bin ������ ����
-- C:\Program Files\MariaDB 11.3\bin
-- cmd â�� ��� ���� ��ɾ� ����
-- [mysql | mariadb] -u [�����ڰ���] -p [������ ������ ���̽���] < [������� ��ġ]
mysql -u root -p employees < C:/test_data/employees.sql

-- ERROR at line 113: Failed to open file 'D:\test_data\load_departments.dump', error: 2
-- �߻��� employees.sql ������ ��� �ϴ��� �ּ� sorce �κ��� ���� �� �ش�.
-- ��> source C:/test_data/load_departments.dump ; -- D�� C�� ����

-- ���� ��� : drop database employees; �� �����ϰ� �ٽ� ��ġ�غ���.

