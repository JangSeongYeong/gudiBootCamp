package Lv02.ex03_숫자의표현;

public class Solution {
	/* 15는 다음과 같이 4가지로 표현 할 수 있습니다.
	 * 
	 * 1 + 2 + 3 + 4 + 5 = 15
	 * 4 + 5 + 6 = 15
	 * 7 + 8 = 15
	 * 15 = 15
	 * 
	 * 자연수 n이 매개변수로 주어질 때, 
	 * 연속된 자연수들로 n을 표현하는 방법의 수를 return하는*/
    public int solution(int n) {
        // 표현 개수
    	int cnt = 0;
    	int sum = 0;
        // 1부터 연속된수를 더하고 n을 넘어선다면 그 다음수부터 더하기 n에 도달하면 종료
    	for (int i = 1; i <= n; i++) {
			for (int j = i; sum<n; j++) {
				sum += j;
			}
			if(sum == n) cnt++;
			sum = 0;
		}
        
        return cnt;
    }
}