package lv01.ex39_시저암호;

public class Solution {
	/* 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 
	 * 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 
	 * 
	 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 
	 * 3만큼 밀면 "DE"가 됩니다. 
	 * "z"는 1만큼 밀면 "a"가 됩니다. 
	 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.*/
   
	/* 공백은 아무리 밀어도 공백입니다.	
	 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
	 * s의 길이는 8000이하입니다.
	 * n은 1 이상, 25이하인 자연수입니다.*/
	
	public String solution(String s, int n) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lower = "abcdefghijklmnopqrstuvwxyz";
        String[] strlist = s.split("");
        StringBuffer buffer = new StringBuffer();
        
        for (String str : strlist) {
        	if(str.equals(" ")) {
        		buffer.append(str);
        		continue;
        	}
			if(Character.isUpperCase(str.charAt(0))) {
				// 대문자일때 uppers 로 동작
				// n이 25이하이기에 %가 아닌 -로 진행
				int upperIdx = upper.indexOf(str.charAt(0))+n;
				if (upperIdx >= 26) {
					upperIdx -= 26;
				}
				buffer.append(upper.charAt(upperIdx));
			} else {
				// 소문자일때 lower 로 동작
				int lowerIdx = lower.indexOf(str.charAt(0))+n;
				if (lowerIdx >= 26) {
					lowerIdx -= 26;
				}
				buffer.append(lower.charAt(lowerIdx));
			}
		}
        
        return buffer.toString();
    }
}