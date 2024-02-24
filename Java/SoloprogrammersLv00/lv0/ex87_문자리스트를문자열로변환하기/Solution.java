package lv0.ex87_문자리스트를문자열로변환하기;

public class Solution {
	/*문자들이 담겨있는 배열 arr가 주어집니다. 
	 * arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.*/
	public String solution(String[] arr) {
        StringBuffer buffer = new StringBuffer();
        
        for (String str : arr) {
			buffer.append(str);
		}
        
        
        return buffer.toString();
    }
}
