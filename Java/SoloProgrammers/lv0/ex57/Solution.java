package lv0.ex57;
// 대문자와 소문자
public class Solution {
	/*문자열 my_string이 매개변수로 주어질 때, 
	 * 대문자는 소문자로 소문자는 대문자로 변환한 문자열을 return하도록 solution 함수를 완성해주세요.*/
	public String solution(String my_string) {
        StringBuffer buffer = new StringBuffer();
        
        // 문자열 char 로 나누기
        char[] clist = my_string.toCharArray();
        
        // 아스키 코드 97 보다 크거나 같으면 소문자
        // 아스키 코드 97 보다 작으면 대문자
        for (int i = 0; i < clist.length; i++) {
			if ((int)clist[i] >= 97) {
				buffer.append((clist[i]+"").toUpperCase());
			} else {
				buffer.append((clist[i]+"").toLowerCase());
			}
		}
        return buffer.toString();
        
    }
}
