package Lv02.ex01_JadenCase문자열만들기;

public class Solution {
	/* JadenCase란 모든 단어의 첫 문자가 대문자이고, 
	 * 그 외의 알파벳은 소문자인 문자열입니다. 
	 * 
	 * 단, 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자로 쓰면 됩니다. 
	 * (첫 번째 입출력 예 참고)문자열 s가 주어졌을 때, 
	 * s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.*/
    public String solution(String s) {
        // 전부 소문자로
    	s = s.toLowerCase();
        
    	int cnt = 0;
    	// 마지막 공백 알아내기
    	for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				cnt++;
			} else {
				break;
			}
		}
    	
        // 1. " " 기준 split 으로 나누기
        String[] split = s.split(" ");
        
        // 2. 첫 글자만 대문자로 upper
        StringBuffer buffer = new StringBuffer();
        for (String str : split) {
        	if (str.equals("")) {
        		buffer.append(" ");
        		continue;
        	}
        	
			if (Character.isLowerCase(str.charAt(0))) {
				str = Character.toUpperCase(str.charAt(0)) + str.substring(1, str.length());
			}
			buffer.append(str+" ");
		}
        String answer = buffer.delete(buffer.length()-1, buffer.length()).toString();
        
        for (int i = 1; i <= cnt; i++) {
			answer += " ";
		}
        
        return answer;
    }
}