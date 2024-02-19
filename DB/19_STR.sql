-- 2. ������ �Լ�: CHAR, VARCHAR Ÿ���� �μ��� �޾� VARCHAR Ÿ���� ���� ��ȯ�ϴ� �Լ��̴�.
-- 1) CONCAT(char1, char2, ...)
SELECT CONCAT('www.', 'mariadb','.org');
 
  
-- 2) LOWER(char), UPPER(char)
-- LOWER : �־��� ���ڿ��� �ҹ��ڷ� ��ȯ���� �ش�.
-- UPPER : �־��� ���ڿ��� �빮�ڷ� ��ȯ���� �ش�.
SELECT UPPER('mariadb') name UNION ALL
SELECT LOWER('mariadb') name;
-- UNION �� �������̸�, UNION ALL �� �ߺ��� �����ϴ� ������ �̴�.


-- 3) LPAD(char1, n [,char2]), RPAD(char1, n [,char2])
-- LPAD : ���ʿ� ���ڿ��� ���� �ִ� ������ �Ѵ�.
-- RPAD : �����ʿ� ���ڿ��� ���� �ִ� ������ �Ѵ�.
-- n�� ��ȯ�Ǵ� ���ڿ��� ��ü ���̸� ��Ÿ����, char1�� ���ڿ��� n���� Ŭ ��� char1�� n�� ���ڿ� ��ŭ �߷��� ��ȯ �Ѵ�.
SELECT LPAD('mydatabase', 12, '*') name;	-- **mydatabase
SELECT RPAD('mydatabase', 12, '*') name;	-- mydatabase**
SELECT RPAD('mydatabase',9,'*') AS pass;	-- mydatabas

-- 4) SUBSTR(char, m ,[n]), SUBSTRB(char, m ,[n])
-- SUBSTR �Լ��� m ��° �ڸ����� ���̰� n���� ���ڿ��� ��ȯ �Ѵ�.
-- m�� ������ ��쿡�� �ڿ��� m ��° ���ں��� n���� ���ڸ� ��ȯ�Ѵ�.
-- SUBSTRB �Լ����� B�� Byte������ ó���ϰڴٴ� �ǹ��̴�.
-- ����° ���� ���ڿ� ��ȯ.
SELECT SUBSTR('mydatabase', 3) name;  
-- ����° ���� �װ��� ���ڿ� ��ȯ.
SELECT SUBSTR('mydatabase', 3, 4) name;
-- �ڿ��� ����°���� �ΰ��� ���ڿ� ��ȯ.
SELECT SUBSTR('mydatabase', -3, 2) name;

-- 5) LENGTH(char)
-- ���ڿ��� ���̸� ��ȯ �Ѵ�.(�ѱ��� �� ���ڿ� 3byte <- UTF-8)
SELECT LENGTH('�����Ƶ��') length;
 

-- 6) REPLACE(char1, str1, str2)
-- REPLACE�� ���ڿ��� Ư�� ���ڸ� �ٸ� ���ڷ� ��ȯ �Ѵ�.
SELECT REPLACE('mydatabase','my','maria ') name;
 
-- ��ҹ��ڸ� �����Ѵٴ� ���� �˼� �ִ�.
SELECT REPLACE('MyDataBase','my','maria ') name;
SELECT REPLACE('MyDataBase','My','maria ') name;
 
 
-- 7) INSTR (char1, str1)
-- ���ڿ��� ���ԵǾ� �ִ����� �����Ͽ� ���ڿ��� ��ġ�� ��ȯ �Ѵ�. 
-- ������ ���ڿ��� �߰ߵ��� ������ 0�� ��ȯ �ȴ�.
-- char1 : ��������, str1 : �˻�����
SELECT INSTR('CORPORATE FLOOR','OK') idx; -- 0 ��ȯ
SELECT INSTR('CORPORATE FLOOR','OR') idx; -- 2 ��ȯ


-- 8) TRIM(char1) ���� ������ �����.
SELECT ' mydatabase ' AS title union ALL
SELECT TRIM(' mydatabase ') AS title;

-- TRIM(char1 FROM char2) Ư���� ���ڿ��� ����ϸ� �� �ڿ��� �����.
SELECT TRIM('��' FROM '�丶��') AS title;


-- 9) LTRIM(char1) -- ���� ���� �����.
SELECT LTRIM(' mydatabase ') AS title; 


-- 10) RTRIM(char1)-- ������ ���� ����
SELECT RTRIM(' mydatabase ') AS title; 
