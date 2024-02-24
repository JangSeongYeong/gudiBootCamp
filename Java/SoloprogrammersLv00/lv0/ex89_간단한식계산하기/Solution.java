package lv0.ex89_간단한식계산하기;

public class Solution {
	/*문자열 binomial이 매개변수로 주어집니다. 
	 * binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수, 
	 * op는 '+', '-', '*' 중 하나입니다. 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.*/
	public int solution(String binomial) {
        
        String[] bs =binomial.split(" ");
        
        int a = Integer.parseInt(bs[0]);
        int b = Integer.parseInt(bs[2]);
        
        
        if (bs[1].equals("+")) {
			return a + b;
		} else if (bs[1].equals("-")) {
			return a - b;
		} else {
			return a * b;
		}
        
    }
}
