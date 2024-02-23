package lv0.ex78_l로만들기;

public class Solution {
	/*알파벳 소문자로 이루어진 문자열 myString이 주어집니다. 
	 *알파벳 순서에서 "l"(L)보다 앞서는 모든 문자를 "l"로 바꾼 문자열을 return 하는 solution 함수를 완성해 주세요.*/
	public String solution(String myString) {
        // c 리스트
        char[] clist = myString.toCharArray();
        
        // l보다 작으면 l로 바꾸기
        for (int i = 0; i < clist.length; i++) {
			if((int)'l' > (int)clist[i]) {
				clist[i] = 'l';
			}
		}
        
        // 리턴하기
        StringBuffer buffer = new StringBuffer();
        for (char c : clist) {
			buffer.append(c);
		}
        return buffer.toString();
    }
}
