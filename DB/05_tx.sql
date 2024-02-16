-- transaction -> TX

-- 1) AUTO COMMIT 여부
-- 주요 작업을 하게된다면 먼저 0인지 확인 
-- 날리거나 실수했을 경우 바로 확인 (조졌을때)
select @@autocommit; -- 1: 설정, 0: 미설정

-- 설정 | 미설정
set autocommit = 1; -- 오토커밋 설정 ON
set autocommit = 0; -- 오토커밋 설정 OFF

-- commit 과 rollback 은 데이터(DML)에 한정된다.
-- DCL, DDL 은 되돌릴 수 없다.

-- 현재 상태 저장하는 것이 commit;
select * from employees;
update employees set commision = 10 where emp_no = 129;
commit;

delete from employees;
-- rollback : commit 하지 않은 내용에 대해서 되돌릴 수 있다.
rollback;

