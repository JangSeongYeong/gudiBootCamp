package lv0.ex111_글자지우기;

public class Solution {
	/*문자열 my_string과 정수 배열 indices가 주어질 때, 
	 * my_string에서 indices의 원소에 해당하는 인덱스의 글자를 지우고 이어 붙인 
	 * 문자열을 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String my_string, int[] indices) {
    
        String[] strlist = my_string.split("");
        
        for (int i = 0; i < indices.length; i++) {
			strlist[indices[i]] = "";
		}
        
        StringBuffer buffer = new StringBuffer();
        
        for (String str : strlist) {
			buffer.append(str);
		}
        
        return buffer.toString();
    }
}
