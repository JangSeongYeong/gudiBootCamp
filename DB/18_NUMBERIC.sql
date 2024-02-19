-- 1. 숫자형 함수 : 수 값을 인수로 받아 NUMBER 타입의 값을 반환하는 함수.
-- 여기서는 자주 사용 하는 함수 몇가지만 소개 한다.

-- 1) ABS(n) : 절대값을 계산하는 함수이다.
SELECT ABS (-1.234) absolute;
-- 결과 : 1.234

-- 2) CEIL(n) : 올림값을 반환하는 함수이다.
SELECT CEIL(10.1234) "CEIL";
-- 결과 : 11
SELECT CEIL(-10.1234) "CEIL";
-- 결과 : -10

-- 3) FLOOR(n) : 버림값을 반환하는 함수이다.
SELECT FLOOR(10.1234) "FLOOR";
-- 결과 : 10
SELECT FLOOR(-10.1234) "FLOOR";
-- 결과 : -11 

-- 4) ROUND(n, [m]) : 반올림, n 값을 반올림, m은 반올림 자릿수
SELECT ROUND(192.153, 1) "ROUND"; 
-- 결과 : 192.2 소숫점 2자리를 반올림 하여 1자리 까지 표현
SELECT ROUND(192.153, -1) "ROUND";
-- 결과 : 190 숫자 2자리를 반올림 하여 1자리 까지 표현

-- 5) TRUNCATE(n, m) : n값을 절삭하는 함수로 m은 소숫점 아래 자릿수를 나타낸다.
SELECT TRUNCATE(7.5597, 2) "TRUNCATE";
-- 결과 : 7.55
 
-- 6) TRUNC 예제
SELECT TRUNCATE(789.5597, -2) "TRUNC";
-- 결과 : 700

-- 7) MOD(m, n) : m을 n으로 나눈 나머지를 반환 한다. n이 0일 경우 m을 반환 한다.
SELECT MOD(9, 4) "MOD" ;
-- 결과 : 1
