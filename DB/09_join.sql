-- JOIN 이란?
-- 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법이다.
-- 두 개의 테이블이 조인하기 위해서는 적어도 하나의 공통된 컬럼이 존재해야 한다.
-- 그래서 일반적으로 부모(PK)와 자식(FK)간에 조인이 수월하게 이루어 진다.

-- JOIN 의 종류 *EQUI JOIN, OUTER JOIN이 가장 중요
-- CROSS JOIN, EQUI JOIN(등가조인, 내부조인)
-- NON-EQUI JOIN(거의 안쓰이기 때문에 다루지 않음)
-- SLEF JOIN, OUTER JOIN

-- 0. CROSS JOIN
-- 두개의 테이블을 카다시안 곱을 수행한다. (모든 경우의 수를 다 곱)
-- emo(10) * dept(4) = 40

-- FROM[tableA] CROSS JOIN [tableB];
select e.ename, d.deptname from emp e cross join dept d;
-- cross join 은 생략 가능 ,로 구분
select e.ename, d.deptname from emp e, dept d;

-- cross join 은 아직 정제되지 않은 순수한 조인 형태
-- 그래서 조건을 주어서 원하는 데이터를 뽑아낸다.


-- 1. Equi Join - 조인 하는 두 테이블 모두에 값에 있을 때만 보여준다.
-- 가장 일반적으로 사용하는 조인(= 를 사용)

-- 1) 등가 조인
select e.ename, d.deptname from emp e, dept d where d.deptno = e.deptno;

insert into dept(deptno, deptname, loc) values('5','dev02','florida');

/* 양쪽에 데이터 불균형이 있을 경우
 * ename, deptname
 * [NULL], personnel
 * [NULL], dev02
 * 이런식으론 보여주지 않음
 */

-- 2) 내부 조인 ON, using
-- FROM [tableA] INNER JOIN [tableB]
-- inner는 생략 가능, 조인을 위한 조건은 where 가 아닌 on을 사용
select e.ename, d.deptname from emp e join dept d on d.deptno = e.deptno;
-- using 을 사용하여 조건을 줄 수 있다.
-- using(서브쿼리) 가 가능하다.
select e.ename, d.deptname from emp e join dept d using (deptno);

-- <추천> on으로 처리하고 나머지를 where로 하는 것을 추천함

-- 3) 네츄럴 조인
-- 네츄럴 조인은 두 테이블 사이 공통되는 컬럼이 있으면 자연스럽게 합쳐지게 된다.
-- 그래서 조인을 위한 조건절이 필요 없다.
-- 주의 사항 : 공통되는 컬럼명은 단축명을 사용하지 않는다. (일부 DB에서 에러 날 수 있음 // 엮어지는 놈)
select e.ename, d.deptname from emp e natural join dept d;


-- 2. 셀프조인
-- Equi-Join 과 똑같다. 다만 두 개의 테이블이 둘 다 자신이라는 것만 다르다.
-- 셀프조인을 하면 두 데이터간 카다시안 곱을 수행한다.
select a.ename, b.job from emp a, emp b where a.deptno = b.deptno;


-- 3. 외부조인 
-- [tableA] [left | right] outer join [tableB] ON 조건절
-- LEFT (왼쪽을 기준으로 더 있는 값을 보여줌) - 여기서 값은 deptno 1,2,3,4,5 | deptno 1,2,4 와 같이 값의 범위를 의미한다.
-- RIGHT (오른쪽을 기준으로 더 있는 값을 보여줌)
-- FULL (서로 없는 값을 보여줌)  -- Maria DB 지원 X
-- outer는 생략 가능
select e.deptno, e.ename, d.deptname 
	from emp e  right outer join dept d on e.deptno = d.deptno; -- 값의 범위가 넓은 쪽을 지정하는게 일반적이다.(범위에 없는게 조인됐다면 NULL 표시)

-- emp 에 deptno 6번을 추가
insert into emp(deptno, ename, job, hiredate) values ('6', 'kim', 'assistant', str_to_date('14-06-02','%Y-%m-%d'));
-- 연계 참조 무결성 제약 조건에 의해서 부모(dept) 에게 없는 6번을 자식(emp)이 넣을 수 없다.
-- 그래서 부모-자식 관계를 해제 -> FK 를 삭제
select * from information_schema.TABLE_CONSTRAINTS where TABLE_NAME = 'emp';
-- alter table [자식테이블] drop constraint [제약조건];
alter table emp drop constraint emp_ibfk_1;

select e.deptno, e.ename, d.deptname 
	from emp e  left outer join dept d on e.deptno = d.deptno;

/* left join : join 을 기준으로 왼쪽 테이블의 데이터를 기준으로 보여준다.(오른쪽에 없는 내용은 null 처리) - 1, 2, 4, 6
 * right join : join 을 기준으로 오른쪽 테이블의 데이터를 기준으로 보여준다.(왼쪽에 없는 내용은 null 처리) - 1, 2, 3, 4, 5
 * full outer join : 서로 없는 내용을 보여줄 수 있는 방법 (Mariadb 지원 X)
 * */



