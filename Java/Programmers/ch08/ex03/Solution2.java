package ch08.ex03;

public class Solution2 {
	// 강사님 코드
	public String solution(int age) {
		String answer = "";
		String pa = "abcdefghij";
		StringBuilder builder = new StringBuilder();
		
		// 1. 숫자를 문자열화 하여 끊고, 숫자로 다시 변환하는 방법(0.13ms~0.17ms)
//		String[] num = String.valueOf(age).split(""); // 나이를 문자열로 바꾸고, 하나씩 끊어서 배열로 만들기
//		
//		for (String n : num) {
//			int idx = Integer.parseInt(n); // 문자를 숫자로 바꾸고 인덱스로 
//			builder.append(pa.charAt(idx)); // 숫자에 맞는 문자를 빌더에 넣기
//		}
		
		// 0.03~0.05;
		while (age>0) { 
			builder.append(pa.charAt(age%10)); // 끝자리가 builder 에 추가
			age /= 10; // 끝자리를 없애기
		}
		
		answer = builder.reverse().toString();
		
		return answer;
		
	}
}
