package lv0.ex148_문자열계산하기;

public class Solution {
	/*my_string은 "3 + 5"처럼 문자열로 된 수식입니다. 
	 * 문자열 my_string이 매개변수로 주어질 때, 
	 * 수식을 계산한 값을 return 하는 solution 함수를 완성해주세요.*/
	public int solution(String my_string) {
        String[] slit = my_string.split(" ");
        int answer = Integer.parseInt(slit[0]);
        for (int i = 1; i < slit.length; i++) {
        	if(slit[i].equals("+")) {
        		answer += Integer.parseInt(slit[i+1]);                	
        	} else if(slit[i].equals("-")){
        		answer -= Integer.parseInt(slit[i+1]);
        	}			
		}
        return answer;
	}
}
