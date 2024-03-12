package Lv02.ex05_피보나치수;

public class Solution {
	/* 피보나치 수는 F(0) = 0, F(1) = 1일 때, 
	 * 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수*/
	
	/* F(2) = F(0) + F(1) = 0 + 1 = 1
	 * F(3) = F(1) + F(2) = 1 + 1 = 2
	 * F(4) = F(2) + F(3) = 1 + 2 = 3
	 * F(5) = F(3) + F(4) = 2 + 3 = 5*/
	
	/* 2 이상의 n이 입력되었을 때, 
	 * n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수*/
    public int solution(int n) {
        
        int fn_1 = 1;
        int fn_2 = 0;
        int fn = 1;
        
        for (int i = 2; i <= n; i++) {
			fn = fn_1 + fn_2;
			fn_2 = fn_1;
			fn_1 = fn%1234567;
		}
        
        return fn%1234567;
    }
}