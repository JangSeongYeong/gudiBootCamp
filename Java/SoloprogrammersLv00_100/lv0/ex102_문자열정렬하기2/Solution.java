package lv0.ex102_문자열정렬하기2;

import java.util.Arrays;

public class Solution {
	/*영어 대소문자로 이루어진 문자열 my_string이 매개변수로 주어질 때, 
	 * my_string을 모두 소문자로 바꾸고 알파벳 순서대로 
	 * 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요.*/
	public String solution(String my_string) {
        String answer = "";
		
        // 소문자로
        answer  = my_string.toLowerCase();
        
        // 정렬
        char[] clit = new char[answer.length()];
        clit = answer.toCharArray();
        Arrays.sort(clit);

        // 문자열로
        StringBuffer buffer = new StringBuffer();
        for (char c : clit) {
			buffer.append(c);
		}
        
        return buffer.toString();
    }
}
