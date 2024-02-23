package lv0.ex09;

public class Solution {
	/*문자열 my_string이 매개변수로 주어집니다. 
	 * my_string안의 모든 자연수들의 합을 return하도록 solution 함수를 완성해주세요.*/ 
	public int solution(String my_string) {
        int answer = 0;
        
        for (char c : my_string.toCharArray()) {
        	switch (c) {
			case '1':
				answer = answer + Character.getNumericValue(c);
				break;
			case '2':
				answer = answer + Character.getNumericValue(c);
				break;
			case '3':
				answer = answer + Character.getNumericValue(c);
				break;
			case '4':
				answer = answer + Character.getNumericValue(c);
				break;
			case '5':
				answer = answer + Character.getNumericValue(c);
				break;
			case '6':
				answer = answer + Character.getNumericValue(c);
				break;
			case '7':
				answer = answer + Character.getNumericValue(c);
				break;
			case '8':
				answer = answer + Character.getNumericValue(c);
				break;
			case '9':
				answer = answer + Character.getNumericValue(c);
				break;
			default:
				continue;
			}
        
		}
        return answer;
    
	}
}
