-- 인덱스(색인) : 검색을 빠르게 해주기 위한 목록
-- 예) 가나다 순으로 각 단어의 위치를 알려주는 목록
-- 그렇다 보니 단어를 추가/삭제 할 때 인덱스도 추가/삭제 해주어야 한다.

-- 1) 고유 인덱스(UNIQUE INDEX)
-- 중복되지 않는 데이터에 대해서만 설정되는 인덱스
-- PK 나 유니크키를 걸어주면 자동으로 생성되는 인덱스
-- 인덱스 생성시 중복데이터가 있으면 에러 발생
-- CREATE UNIQUE INDEX [인덱스 이름] ON [테이블명] (컬럼);
create unique index emp_ename_idx on emp(ename);
select * from emp;

-- 2) 비고유 인덱스(NON UNIQUE INDEX)
-- FK 생성시 이 인덱스가 걸려 있다.
-- 중복 데이터가 있어도 인덱스 생성이 가능
-- CREATE INDEX [인덱스 이름] ON [테이블명] (컬럼);
create index emp_ename_idx on emp(ename);

-- 3) 결합(복합) 인덱스 	
-- 복합키처럼 여러 컬럼을 조합해서 인덱스 생성이 가능(16개 까지 가능)
-- CREATE [UNIQUE] INDEX [인덱스 이름] ON [테이블명] (컬럼, ...);
create unique index emp_combi_idx on emp(ename, job, deptno);

-- 4) 인덱스 확인 방법
-- show index from [테이블명]
show index from emp;

-- 5) 인덱스 삭제
-- 인덱스는 테이블 속성으로 취급
-- ALTER TABLE [테이블명] DROP INDEX [인덱스이름];
alter table emp drop index emp_ename_idx;
