package lv0.ex08;

public class Solution {
	/*정수 n이 매개변수로 주어질 때 
	 * n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요*/
	public int solution(int n) {
        int answer = 0;
        int number = n;
        // 끝의 자리를 계속 더하고 뒤를 없애다가 0이 나오면 종료
        while(true) {
        	answer = answer + number%10;
        	number = number/10;
        	if(number == 0) {
        		break;
        	}
        }
        
        
        return answer;
    }
}
