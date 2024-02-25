package lv0.ex120_팩토리얼;

public class Solution {
	/*i팩토리얼 (i!)은 1부터 i까지 정수의 곱을 의미합니다. 
	 * 예를들어 5! = 5 * 4 * 3 * 2 * 1 = 120 입니다. 
	 * 정수 n이 주어질 때 다음 조건을 만족하는 가장 큰 정수 i를 return 하도록 solution 함수를 완성해주세요.
	 * i! ≤ n*/
	public int solution(int n) {
        int answer = 0;
        int facresult;
        for (int i = 1; i < 11; i++) {
        	// 초기화
        	facresult = i;
        	
        	// 팩토리얼 구하기
			for (int j = i-1; j >= 1; j--) {
				facresult *= j;
			}
			
			// 비교
			if (facresult > n) {
				answer = i-1;
				break;
			} else if (facresult == n) {
				answer = i;
				break;
			}
		}
        
        return answer;
    }
}
