package lv0.ex126_한번만등장한문자;

import java.util.Arrays;

public class Solution {
	/*문자열 s(abcabcadc)가 매개변수로 주어집니다. 
	 * s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.*/
	public String solution(String s) {
        StringBuffer buffer = new StringBuffer();
        //indexof 사용합시다 lastindexof
        for (int i = 0; i < s.length(); i++) {
        	if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
        		buffer.append(s.charAt(i));
			}
		}
        
        char[] clist = buffer.toString().toCharArray();
        
        Arrays.sort(clist);
        
        buffer.delete(0, buffer.length());
        
        for (char c : clist) {
			buffer.append(c);
		}
        
        return buffer.toString();
    }
}
