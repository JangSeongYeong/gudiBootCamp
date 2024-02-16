-- 1. 데이터 조회
-- 1) 특정 컬럼 조회
-- SELECT [조회할 컬럼] FROM [테이블명];
select * from employees;
select first_name, family_name, mobile from employees;
-- 어떤 것을 보여줄 것인가? 그것은 어떤 테이블에 있는가? 가 쿼리에 가장 중요한 요소이다.

-- 산술 표현
-- 숫자로된 컬럼에 대해서는 계산해서 보여줄 수 있다.(실제로 계산되는 건 아님)
select first_name, family_name, salary/10000 from employees; -- 휘발성인 salay/10000 인 컬럼이 생김

-- 컬럼명을 임시로 변경해서 보여줄 수도 있다.
select first_name, family_name, salary/10000 as 급여 from employees; -- 컬럼 이름을 보여주는 곳에서 급여로 변경

-- 보여주는 순서 변경 가능
select family_name, first_name, salary/10000 as 급여 from employees; -- 컬럼의 위치로 보여주는 순서가 다름

-- 문자열을 합칠 수도 있다.
select 
	concat(family_name, first_name) as 이름,
	concat(truncate(salary/10000,0),'만원') as 급여 
from employees; 
-- concat을 통해서 붙이기 (데이터 타입 문자열 한정)
-- truncate(1,2) : 1번 값에 소수점은 2개 붙일 것이다.
-- 문자열을 넣을때는 꼭 싱글 쿼터 : 더블은 다른 것으로 인식해버림

select * from employees;
-- 위에 많은 작업을 했지만 원본 데이터에는 수정사항이 없다.
-- 이 모든건 실제 데이터를 가공해서 보여줄 뿐이지 조작 되진 않는다.

-- 2) 특정 조건의 데이터를 조회
-- SELECT [조회할 컬럼] FROM [테이블] WHERE [조건]
-- 김씨만 출력	
select * from employees where family_name = '김'; -- DB는 대입이 없어 ==이 아닌 = 한개로 같다 표시

-- 월급 300만원 이상만 출력
select  * from employees where salary >= 3000000;

-- && : AND
-- salary > = 1000000 && salary <= 3000000;
select  * from employees where salary >= 1000000 and salary <= 3000000;

-- || : OR
-- family_name == '김' || salary = 2000000;
select  * from employees where family_name = '김' OR salary = 2000000;

-- BETWEEN AND (특정값 사이를 구할때 사용)
-- AND 조건을 이용해서 salary 가 50만원 보다 크거나 같고, 400만원 보다 작거나 같은 사람의 first_name, fimaily_name, salary 를 구하시오.
select  first_name , family_name, salary from employees where salary >= 500000 and salary <= 4000000;
-- 부등호가 특수문자로 인식되는 경우가 있어서 피하고자 할때 종종 사용된다.
select  first_name , family_name, salary from employees where salary between 500000 and 4000000;
-- between A AND B : A와 B 사이

-- 3) 중복 제거
-- SELECT DISTINCT [출력할 컬럼] FROM [테이블]
select family_name from employees where salary = 2000000;
-- distinct 는 하나의 컬럼만 사용할 때 가장 정확한 효과가 나타난다.
select distinct family_name from employees where salary = 2000000;

-- 4) IN(OR하고 똑같다.)
-- family_name 이 '김' 또는 '이' 또는 '박' 인 사람의 모든 정보를 가져와라
select * from employees where family_name = '김' OR family_name = '이' or family_name = '박';
-- or 로 비교하는 컬럼이 모두 같을 경우 사용한다. (속도가 훨씬 빠르다. : 데이터 몇 만건이 있으면 차이가 확실함)
select * from employees where family_name in ('김', '이','박');

-- 5) IS NULL || IS NOT NULL;
-- commision 이 10 인 녀석을 찾아서 null로 만들어라
update employees set commision = null where commision = 10;

select * from employees where commision is null;
select * from employees where commision is not null;

-- 6) LIKE 
-- 일부 비슷한 문자열을 검색 - 검색 기능을 사용할때 가장 많이 사용 (데이터 양이 적을 때 사용 - 많을 경우 전용 검색 엔진)
-- WHERE [컬럼명] LIKE '%[문자열]%'
-- 남발할 경우 속도 저하가 심하다.

-- ze% 			: ze 로 시작하지만 뒤에는 아무거나 와도 된다.				-> ze 로 시작하는...
-- %com 		: 앞에 아무거나 와도 되지만 뒤는 com 으로 끝나야 한다.	-> com 으로 끝나는...
-- %se%		: se 앞 뒤에 아무거나 와도 된다.							-> se를 포함하는...
-- %s%e%	: s 와 e 사이에 아무거나 와도 된다.							-> s 또는 e를 포함하는...

select * from employees where email like 'ze%';
select * from employees where email like '%com';
select * from employees where email like '%se%'; -- 가장 중요
select * from employees where email like '%s%e%';

-- 7) ORDER BY(정렬)
-- 특정 컬럼을 기준으로 정렬
-- 오름차순(▲) ASC | 내림차순(▼)DESC
-- SELECT * FROM [테이블명] ORDER BY [컬럼명] [ASC|DESC];
select * from employees order by salary desc ;
select * from employees order by family_name asc ;
select * from employees order by family_name ; -- asc 는 생략이 가능하다.

-- 김씨 중에서 급여가 높은 순으로 정렬하세요
select * from employees where family_name = '김' order by salary desc;	-- 정렬은 가장 마지막으로 들어가야 한다.
-- 연봉이 높은 순으로 정렬하세요.
select concat(family_name, first_name) as name, email , salary*12 as ann_sal from employees order by ann_sal desc;
-- 다중정렬(1차 정렬 후, 동률의 데이터에서 2차 정렬을 진행)
select * from employees order by family_name, salary desc;


-- 8) GROUP BY
-- 데이터를 특정 컬럼을 기준으로 묶어서 가져오는 경우 사용(통계)
-- SELECT [컬럼1], [컬럼2], ... FROM [테이블이름] GROUP BY [묶어줄 컬럼];
-- 조회되는 컬럼들은 묶어주는 기준 컬럼이거나, 집계되는 컬럼이어야 한다.

-- 부서별로 급여 합산
select depart_no, truncate(salary/10000,0) from employees order by depart_no;
-- 10389만원, 560만원, 650만원, 2520만원, 770만원 위 처럼 하면 하나씩 알아서 계산

select depart_no, sum(salary) from employees where depart_no = 'dev001';
select depart_no, sum(salary) from employees where depart_no = 'dev002';
select depart_no, sum(salary) from employees where depart_no = 'dev003';
select depart_no, sum(salary) from employees where depart_no = 'dev004';
select depart_no, sum(salary) from employees where depart_no = 'dev005';

-- 위 내용을 group by로 변환
select depart_no, sum(salary) from employees group by depart_no;

-- 그룹의 기준이 되는 컬럼과, 집계 컬럼 외의 다른 컬럼이 들어간다면?
-- 나오긴 하지만 그 의미를 알 수 없다. -> 각 그룹의 가장 첫 값을 보여준다.
-- 다른 DB 에서는 이 경우 에러를 발생시킬수도 있다.
select depart_no, sum(salary), family_name from employees group by depart_no;

-- 부서별 급여 평균 - AVG(column)
select depart_no, truncate(avg(salary),0) as sal_avg from employees group by depart_no;

-- HAVING
-- GROUP BY 에서 WHERE 처럼 조건을 주고 싶을 때 사용 ( WHERE 사용 불가)
-- having 은 별칭은 사용하면 안된다.(total 대신 sum(salary)를 써야 한다.)
-- 마리아에서는 허용 해 주지만 몇몇 DB에서는 에러가 발생한다.
select depart_no, sum(salary) as total 
	from employees group by depart_no having total > 5000000;

select depart_no, sum(salary) as total 
	from employees group by depart_no having sum(salary) > 5000000;

-- 급여 합계가 500만원 이상인 부서들을 합계 급여가 높은 순으로 정렬하세요.
select depart_no, sum(salary) as total 
	from employees group by depart_no having sum(salary) >= 5000000 order by total desc;
