package lv0.ex144_잘라서배열로저장하기;

import java.util.ArrayList;

public class Solution {
	/*문자열 my_str과 n이 매개변수로 주어질 때, 
	 * my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.*/
	public String[] solution(String my_str, int n) {
        
        ArrayList<String> list = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        
		for (int i = 0; i < my_str.length(); i++) {
			if(i%n == n-1 || i == my_str.length()-1) {
				buffer.append(my_str.charAt(i));
				list.add(buffer.toString());
				buffer.delete(0, buffer.length());
			} else {
				buffer.append(my_str.charAt(i));
			}
		} 
		
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
        return answer;
    }
}
