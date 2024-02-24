package lv0.ex103_세로읽기;

public class Solution {
	/*문자열 my_string과 두 정수 m, c가 주어집니다. 
	 * my_string을 한 줄에 m 글자씩 가로로 적었을 때 
	 * 왼쪽부터 세로로 c번째 열에 적힌 글자들을 문자열로 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String my_string, int m, int c) {
        
        StringBuffer buffer = new StringBuffer();
        
        int idx = c-1;
        while (idx < my_string.length()) {
        	buffer.append(my_string.charAt(idx));
        	idx += m;
		}
        
        return buffer.toString();
    }
}
