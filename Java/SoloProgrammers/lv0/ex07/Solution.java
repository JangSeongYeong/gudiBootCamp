package lv0.ex07;

public class Solution {
/* 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 
 * 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.	
 */
	public String solution(String my_string) {
        String answer = "";
        for(char d : my_string.toCharArray()) {
			if(d == 'a' || d == 'e' ||d == 'i' ||d == 'o' ||d == 'u') {
				continue;
			} else {
				answer = answer + d;
			}
		}
        return answer;
    }
	
// switch로 하는 것도 괜찮을 듯
}
