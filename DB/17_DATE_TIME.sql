/* 1. ��¥ ǥ�� */
-- 1) dayofweek(date) : ��¥�� �� ���� �� ��° ���������� ��Ÿ���� ���ڷ� �����Ѵ�.
-- (1 = �Ͽ���, 2 = ������, ... 7 = �����)
select dayofweek('2021-06-30') as '����'; -- 4

-- 2) weekday(date) : ��¥�� �� ���� �� ��° ���������� ��Ÿ���� ���ڷ� �����Ѵ�. 
-- (0 = ������, 1=ȭ���� ... 6 = �Ͽ���)
select weekday('2021-06-30') as '����'; -- 2

-- 3) dayofmonth(date) : �� ���� �� ��° �������� �˷��ش�. ���� ���� 1���� 31 �����̴�.
select dayofmonth('2021-06-29') as '��';

-- 4) dayofyear(date) : �� ���� �� ��° �������� �˷��ش�. ���� ���� 1���� 366 �����̴�.
select dayofyear('2021-01-12');
select dayofyear('2021-07-30');

-- 5) month(date) : �ش� ��¥�� �� ������ �˷��ش�. ���� ���� 1���� 12 �����̴�.
select month('2021-02-03');

-- 6) dayname(date) : �ش� ��¥�� ����� �����̸��� �����Ѵ�.
select dayname('2021-12-25');

-- 7) monthname(date) : �ش� ��¥�� ����� �� �̸��� �����Ѵ�.
select monthname('2021-02-05');

-- 8) quarter(date) : �б⸦ �����Ѵ� (1~ 4)
select quarter('2021-04-01') as '�б�';

-- 9) week(date) : �ش� ��¥�� �� ��° ���������� ����
-- select week('date',[mode]);
/*
mode  ����    ����
0	 Sunday	0-53	���� ù° ���� �Ͽ���
1	 Monday	0-53	���� ù° ������ �������̰� ù° �ְ� 3�� �̻��� ���
2	 Sunday	1-53	���� ù° ���� �Ͽ���
3	 Monday	1-53	���� ù° ������ �������̰� ù° �ְ� 3�� �̻��� ���
4	 Sunday	0-53	���� ù° ������ �Ͽ����̰� ù° �ְ� 3�� �̻��� ���
5	 Monday	0-53	���� ù° ���� ������
6	 Sunday	1-53	���� ù° ������ �Ͽ����̰� ù° �ְ� 3�� �̻��� ���
7	 Monday	1-53	���� ù° ���� ������
*/
select week('1998-01-01'); 	  -- mode �� ������� ������ 0�� ����.
select week('1998-01-01',0);  -- 0
select week('1998-01-01',1);  -- 1
 

/* 2. ��¥ ��� */
-- 1) period_add(p,n) : yymm �Ǵ� yyyymm �������� �־��� �޿� n������ ���Ѵ�. ���� ���� yyyymm�� �����̴�.
select period_add(2109,36); -- 202409

-- 2) period_diff(p1,p2) : yymm �Ǵ� yyyymm �������� �־��� �� �Ⱓ������ ������ ���Ѵ�
select period_diff(2104,202109); -- -5
select period_diff(202104,202109);

-- 3) date_add(date,interval expr type) or adddate(date,interval expr type)
-- Ư���� ������ ���Ѵ�.
-- seconds, minutes, hours, days, months, years
select date_add("2021-12-31 23:59:59",interval 1 second); -- 1�� ���ϱ�
select date_add("2021-12-31 23:59:59",interval 30 day); -- 30�� ���ϱ�
select date_add("2021-12-31 23:59:59",interval 1 month); -- 1���� ���ϱ�
select date_add("2021-12-31 23:59:59",interval "10:1" minute_second); -- 10��:1�� ���ϱ�
select date_add("2021-12-31 23:59:59",interval "1:30" hour_minute); -- 1�ð�:30�� ���ϱ�


-- 4) date_sub(date,interval expr type) or subdate(date,interval expr type)
-- Ư���� ������ ����.
-- seconds, minutes, hours, days, months, years
select date_sub("2022-01-01 00:00:00",interval "1 1" day_hour); 		-- 1�� 1�ð�
select date_sub("2022-01-01 00:00:00",interval "1-1" year_month); 		-- 1��-1����
select date_sub("2022-01-01 00:00:00",interval "1:1:1" hour_second);	-- 1�ð�:1��:1�� ����
select date_sub("2022-01-01 00:00:00",interval "1 1:1" day_minute);		-- 1�� 1�ð�:1�� ����
select date_sub("2022-01-01 00:00:00",interval "1 1:1:1" day_second);	-- 1�� 1�ð�:1��:1�� ����


-- 5) to_days(date) : �־��� ��¥�� 0000��-00��-00�� ������ �ϼ��� �ٲ۴�.
select to_days(210629); -- 0000��-00��-00�� ���� 2021��-06��29�� ������ �� ��
select to_days('2021-06-29');
 
-- 6) from_days(n) : �־��� �ϼ��κ��� ��¥�� ���Ѵ�(to_days �ݴ� ����)
select from_days(738335);


/* 3. ��¥ ���� */
-- 1) date_format(date,format) format �� ���ǿ� ���� ���� Ȥ�� �ð��� ����Ѵ�. 

-- %y : 2�ڸ� �⵵ - %Y �� 4�ڸ� �⵵
-- %m : ��(01~12) - %M �� �� �̸�
-- %d ��(00~31)
select date_format('2021-07-01 13:54:00', '%y�� %m�� %d��');
select date_format('2021-07-01 13:54:00', '%M %Y');

-- %b : ª�� ���̸� (jan..dec)
-- %D : ����� ���̻縦 ���� ��(1st, 2nd, 3rd, etc.)
-- %a : ª�� ���ϸ�(sun~sat)
select date_format('2021-07-01 13:54:00', '%b %D (%a)');
-- %W : ���ϸ�, %w : �������� �� ��° �����ΰ�(0=sunday~6=saturday) 
select date_format('2021-07-01 13:54:00', '%b %D (%W)');

-- %c : ��(1~12), %e : ��(0~31), %H : 24�� ������ �ð� (00~23), %i : ��, %s : ��(00~59)
select date_format('2021-07-01 13:54:00', '%c-%e %H:%i:%s');

-- %h : 12�� ������ �ð� (01~12), %p : am �Ǵ� pm ����
select date_format('2021-07-01 13:54:00', '%h:%i:%s %p');

-- %r : �ú���12�� ���� (hh:mm:ss [ap]m)
select date_format(NOW(), '%r');

-- %T : �ú��� 24�� ���� (hh:mm:ss)
select date_format(NOW(), '%T');

-- %U : ������ �� ��° ���ΰ�(0~52) �Ͽ����� ������
-- %u : ������ �� ��° ���ΰ�(0~52) �������� ������
select date_format(NOW(), '%U');


-- 2) time_format(time,format) : date_format()�� ����� ������ ������ ���� ��,��,�� ���� ��Ÿ�� �� �ִ�.
select date_format('2021-07-01 13:54:00', '%h:%i:%s %p') 
	union all
select time_format('2021-07-01 13:54:00', '%h:%i:%s %p');
 
-- 3) curdate() : ���� ��¥�� ���� ��¥�� 'yyyy-mm-dd' �������� ����
select curdate(); -- yyyy-mm-dd
select curdate() + 0; -- yyyymmdd

-- 4) curtime() : 'hh:mm:ss' �������� ����ð��� ��Ÿ����.
select curtime();		-- hh:mm:ss
select curtime() + 0;	-- hhmmss

-- 5) now() | sysdate() | current_timestamp() : ���� ���ڿ� ���� �ð��� 'yyyy-mm-dd hh:mm:ss' �������� ��ȯ
select now();
select now() + 0;

 
-- 6) unix_timestamp(date)
-- �μ��� ���� ���� ��� ���� �ð��� ���н� Ÿ�ӽ�����, 
-- ��¥������ date �� �μ��� �־��� ��쿡�� �־��� ��¥�� ���н� Ÿ�ӽ������� ��ȯ
-- ���н� Ÿ�ӽ����� : �׸���ġ ǥ�ؽ÷� 1970 �� 1�� 1�� 00:00:00 �� ���� �ð������ �ʴ����� ��Ÿ�� ��
select unix_timestamp();
select unix_timestamp(now());


-- 7) from_unixtime(unix_timestamp) : �־��� ���н� Ÿ�ӽ����� �����κ��� 'yyyy-mm-dd hh:mm:ss' ������ ��¥�� ��ȯ
select from_unixtime(1625031063);
select from_unixtime(1625031063) + 0;

-- 8) from_unixtime(unix_timestamp,format) : �־��� ���н� Ÿ�ӽ����� ���� �־��� ��¥ ���Ŀ� �°� �ٲ㼭 �����ش�. 
select from_unixtime(unix_timestamp(),'%Y-%m-%d %h:%i:%s');

-- 9) sec_to_time(seconds) : �־��� �ʸ� 'hh:mm:ss' �������� ��ȯ
select sec_to_time(2378);
select sec_to_time(2378) + 0;

-- 10) time_to_sec(time) : �־��� �ð��� �� ������ �ٲ��ش�.
select time_to_sec('22:23:00');

-- Ư�� ��-�� �� ������ ��¥ ���ϱ�
select LAST_DAY('2022-02-01') as date; 

-- ��¥�� ��¥ ���� ��� ��¥ ���ϱ�
select * from (
	select adddate('2000-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) date_of_month from
		(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
		(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
		(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
		(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
		(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4
) v where date_of_month between '2022-10-01' and LAST_DAY('2022-10-01');

-- ��¥ ��������  right outer join
select b.idx,b.bHit, m.reg_date from bbs b RIGHT OUTER JOIN (
	select * from (
		select adddate('2000-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) reg_date from
			(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
			(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
			(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
			(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
			(select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4
	) v
where reg_date between '2022-10-01' and LAST_DAY('2022-10-01')) m 
	ON b.reg_date = m.reg_date order by m.reg_date;
