-- 백업 파일(dump)을 데이터베이스로 복원하는 방법
-- 1. 복원할 데이터 베이스를 생성(없을 경우,,,)
create database employees;
show databases;

-- 2. mariaDB 가 설치되어 있는 bin 폴더로 접근
-- C:\Program Files\MariaDB 11.3\bin
-- cmd 창을 열어서 다음 명령어 실행
-- [mysql | mariadb] -u [관리자계정] -p [복원할 데이터 베이스명] < [백업파일 위치]
mysql -u root -p employees < C:/test_data/employees.sql

-- ERROR at line 113: Failed to open file 'D:\test_data\load_departments.dump', error: 2
-- 발생시 employees.sql 파일을 열어서 하단의 주소 sorce 부분을 수정 해 준다.
-- 예> source C:/test_data/load_departments.dump ; -- D를 C로 수정

-- 연습 방법 : drop database employees; 를 진행하고 다시 설치해본다.

