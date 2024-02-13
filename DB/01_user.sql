-- �ּ� (-- )
/*1. ���� ����*/
-- CREATE USER  [�����̸�]@[���ٰ����� IP] IDENTIFIED BY [��й�ȣ];

-- web_user �� ��� IP ���� ���� �����ϰ�, ��й�ȣ�� pass �� ������
create user 'web_user'@'%' identified by 'pass';

-- dba_user �� 192.168 �� ���۵Ǵ� IP ���� ���� �����ϰ�, ��й�ȣ�� pass �� ������
-- Ư�� IP �뿪�� ���� �����ϰ� �� ���
create user 'dba_user'@'192.168.%' identified by 'pass';

-- user002 �� 192.168.38.70 IP ������ ���� �����ϰ�, ��й�ȣ�� pass3 �� ������
create user 'user002'@'192.168.38.70' identified by 'pass3';

-- ���� ���� Ȯ��
select * from mysql.user;

/*2. ���� �ο� �� ȸ��*/
-- ���� �ο�(GRANT)
-- GRANT [��������] ON	[�����ͺ��̽�.���̺�] TO [������];
-- �����͸� INSERT(�߰�), UPDATE(����), SELECT(��ȸ), DELETE(����)
-- ALL PRIVILEGES : GRANT OPTION �� ������ ��� ���� �ο�
-- GRANT OPTION : ������ �ִ� ����

-- dba_user ���� ��� �����ͺ��̽��� ��� ���̺��� �����͸� �� �� �ִ� ������ �ش�.
-- user ����� �� IP �� �Բ� ����ؾ� �Ѵ�.
grant select on *.* to 'dba_user'@'192.168.%'; 

-- user002 ���� ��� �����ͺ��̽��� ��� ���̺��� �����͸� ����, �߰��ϰ�, �����ϰ�, ������ �� �ִ� ������ �ش�.
grant select, insert, update, delete on *.* to 'user002'@'192.168.38.70';

-- web_user ���� ��� �����ͺ��̽��� ��� ���̺��� �����͸� ������ �� �� �ִ�(���� �ִ°� ����) ������ �ش�.
-- IP �� % �� ���� ���� ����
grant all privileges on *.* to 'web_user'@'%';
grant all privileges on *.* to 'web_user';

-- ���� ������ user Ȯ�ο��� �����ϴ�.
select * from mysql.user;

/*���� ����*/
-- DROP USER [���� �̸�]@[IP]
drop user 'dba_user'@'192.168.%';