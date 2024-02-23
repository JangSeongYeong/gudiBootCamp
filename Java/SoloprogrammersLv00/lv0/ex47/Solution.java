package lv0.ex47;

public class Solution {
	/*문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다. 
	 * my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 
	 * 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.
	 * */
	public String solution(String my_string, int[] index_list) {
        
        StringBuffer buffer = new StringBuffer(); 
        
        // 문자열 배열에 저장
        char[] strlist = my_string.toCharArray();
        
        // for 문을 통해 원하는 값을 버퍼에 추가
        for (int i = 0; i < index_list.length; i++) {
			buffer.append(strlist[index_list[i]]);
		}
        
        // 버퍼를 문자열로 전환 후 return
        return buffer.toString();
    }
}
