select * from employees e ; -- 14개
-- 5개 씩
-- 0~4, 5~9 10~14
-- limit n : n개 보여주기
select * from employees e limit 5;

-- limit n,m : n번 부터 m 개
select * from employees e limit 0, 5;
select * from employees e limit 5, 5;
select * from employees e limit 10, 5;

-- offset n : n번 부터
select * from employees e limit 5 offset 0;
select * from employees e limit 5 offset 5;
select * from employees e limit 5 offset 10;

-- 위 내용은 일반적인 페이징 처리 방식
-- 위 방식은 데이터가 많아지면 느려진다.
-- offset의 순서를 위해서 하나씩 세면서 내려가기 때문

-- 속도 개선 1단계> 데이터를 정렬 후 내용을 가져온다.
select e.emp_no, e.first_name, e.family_name 
	from (select * from employees e order by emp_no) e
		limit 0, 5;	

-- 속도 개선 2단계> 인덱스가 없다면 인덱스 추가
desc employees;
-- 인덱스가 있다면 활용

select e.emp_no, e.first_name, e.family_name 
	from (select * from employees e order by emp_no limit 0, 5) e
	join employees e2 on e.emp_no = e2.emp_no;	
-- 이게 왜 빠를까?
-- 조인을 통해서 이미 적용된 인덱스를 활용해서 값을 찾는 방식이므로 더 빠르다.

