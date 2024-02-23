package lv0.ex06;

public class Solution {
	// 어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return
	public int solution(int n) {
		// sqrt로 제곱근을 구하기
        double answer = Math.sqrt(n);
        // 1로 나눔으로써 소수점이 있는지 확인
        if(answer % 1 == 0) {
        	return 1;
        } else {
        	return 2;
		}
        
    }
	
}
