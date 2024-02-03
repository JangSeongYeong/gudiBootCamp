package ch08.ex03;

public class Solution {
	public String solution(int age) {
		// a는 0, b는 1, c는 2, ..., j는 9
		// 받은 age를 나이에 맞춰서 영문으로 출력
		String answer = "";
		// 1000, 100, 10단위로 나누고 나누어떨어지면 그 단위부터 문자로 바꾸기
		// 아스키 코드 a  = 97값을 사용하여 더함으로 문자로 변환
		StringBuffer buffer = new StringBuffer();
		
		if(age/1000 != 0) {
			answer = "baaa";
			return answer;
		} else if(age/100 != 0) {
			int ch = 97 + age/100;
			buffer.append((char)ch);
			
			ch = 97 + (age%100)/10;
			buffer.append((char)ch);
			
			ch = 97 + age%10;
			buffer.append((char)ch);
		} else if(age/10 != 0) {
			int ch = 97 + age/10;
			buffer.append((char)ch);
			
			ch = 97+age%10;
			buffer.append((char)ch);
		} else {
			int ch = 97+age%10;
			buffer.append((char)ch);
		}
		
		answer = buffer.toString();
		
		return answer;		
	
	}
}
