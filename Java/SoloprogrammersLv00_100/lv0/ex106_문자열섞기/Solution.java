package lv0.ex106_문자열섞기;

public class Solution {
	/*길이가 같은 두 문자열 str1과 str2가 주어집니다.
	 * 두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 
	 * 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.*/
	public String solution(String str1, String str2) {
		StringBuffer buffer = new StringBuffer();
        
		for (int i = 0; i < str1.length(); i++) {
			buffer.append(str1.charAt(i));
			buffer.append(str2.charAt(i));
		}
		
        return buffer.toString();
    }
}
