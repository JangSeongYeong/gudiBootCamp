package lv01.ex34_3진법뒤집기;

import java.util.*;

public class Solution {
	/* 자연수 n이 매개변수로 주어집니다. 
	 * n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 
	 * return 하도록 solution 함수를 완성해주세요.
	 * 
	 * n은 1 이상 100,000,000 이하인 자연수입니다.
	 * */
    public int solution(int n) {
    	// 1 3^0
    	// 3 3^1
    	// 9 3^2
    	// 27 3^3
    	
    	// 3진수 배열 크기 만들기
    	int answer = 3;
        int count = 1;
        while (answer <= n) {
			answer *= 3;
			count++;
		}
        answer /= 3;
        
        // 3진법 변환
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
			list.add(n/answer);
			n %= answer;
			answer /= 3;
        }
        // reverse
        // Collections.reverse(list);
        
        // 10진수로
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
        	result += (int)Math.pow(3, i) * list.get(i);
		}
        return result;
    }
}