-- 2. 문자형 함수: CHAR, VARCHAR 타입을 인수로 받아 VARCHAR 타입의 값을 반환하는 함수이다.
-- 1) CONCAT(char1, char2, ...)
SELECT CONCAT('www.', 'mariadb','.org');
 
  
-- 2) LOWER(char), UPPER(char)
-- LOWER : 주어진 문자열을 소문자로 변환시켜 준다.
-- UPPER : 주어진 문자열을 대문자로 변환시켜 준다.
SELECT UPPER('mariadb') name UNION ALL
SELECT LOWER('mariadb') name;
-- UNION 은 합집합이며, UNION ALL 은 중복을 포함하는 합집합 이다.


-- 3) LPAD(char1, n [,char2]), RPAD(char1, n [,char2])
-- LPAD : 왼쪽에 문자열을 끼어 넣는 역할을 한다.
-- RPAD : 오른쪽에 문자열을 끼어 넣는 역할을 한다.
-- n은 반환되는 문자열의 전체 길이를 나타내며, char1의 문자열이 n보다 클 경우 char1을 n개 문자열 만큼 잘려서 반환 한다.
SELECT LPAD('mydatabase', 12, '*') name;	-- **mydatabase
SELECT RPAD('mydatabase', 12, '*') name;	-- mydatabase**
SELECT RPAD('mydatabase',9,'*') AS pass;	-- mydatabas

-- 4) SUBSTR(char, m ,[n]), SUBSTRB(char, m ,[n])
-- SUBSTR 함수는 m 번째 자리부터 길이가 n개인 문자열을 반환 한다.
-- m이 음수일 경우에는 뒤에서 m 번째 문자부터 n개의 문자를 반환한다.
-- SUBSTRB 함수에서 B는 Byte단위로 처리하겠다는 의미이다.
-- 세번째 이후 문자열 반환.
SELECT SUBSTR('mydatabase', 3) name;  
-- 세번째 이후 네개의 문자열 반환.
SELECT SUBSTR('mydatabase', 3, 4) name;
-- 뒤에서 세번째아후 두개의 문자열 반환.
SELECT SUBSTR('mydatabase', -3, 2) name;

-- 5) LENGTH(char)
-- 문자열의 길이를 반환 한다.(한글은 한 글자에 3byte <- UTF-8)
SELECT LENGTH('마리아디비') length;
 

-- 6) REPLACE(char1, str1, str2)
-- REPLACE는 문자열의 특정 문자를 다른 문자로 변환 한다.
SELECT REPLACE('mydatabase','my','maria ') name;
 
-- 대소문자를 구분한다는 것을 알수 있다.
SELECT REPLACE('MyDataBase','my','maria ') name;
SELECT REPLACE('MyDataBase','My','maria ') name;
 
 
-- 7) INSTR (char1, str1)
-- 문자열이 포함되어 있는지를 조사하여 문자열의 위치를 반환 한다. 
-- 지정한 문자열이 발견되지 않으면 0이 반환 된다.
-- char1 : 지정문자, str1 : 검색문자
SELECT INSTR('CORPORATE FLOOR','OK') idx; -- 0 반환
SELECT INSTR('CORPORATE FLOOR','OR') idx; -- 2 반환


-- 8) TRIM(char1) 양쪽 공백을 지운다.
SELECT ' mydatabase ' AS title union ALL
SELECT TRIM(' mydatabase ') AS title;

-- TRIM(char1 FROM char2) 특정한 문자열을 명시하면 앞 뒤에서 지운다.
SELECT TRIM('토' FROM '토마토') AS title;


-- 9) LTRIM(char1) -- 왼쪽 공백 지운다.
SELECT LTRIM(' mydatabase ') AS title; 


-- 10) RTRIM(char1)-- 오른쪽 공백 지움
SELECT RTRIM(' mydatabase ') AS title; 
