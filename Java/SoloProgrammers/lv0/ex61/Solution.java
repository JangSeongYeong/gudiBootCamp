package lv0.ex61;

import java.util.ArrayList;

// 공백으로 구분하기 2
public class Solution {
	/*단어가 공백 한 개 이상으로 구분되어 있는 문자열 my_string이 매개변수로 주어질 때, 
	 * my_string에 나온 단어를 앞에서부터 순서대로 담은 문자열 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public String[] solution(String my_string) {
        ArrayList<String> list = new ArrayList<String>();
		
        // 앞뒤 공백 제거 후 배열에 넣기
        String[] answer = {};
        String reStr = my_string.trim();
        answer = reStr.split(" ");
       
        // 문자만 list 에 넣기 equals!!!!!!!!!!
        for (String str : answer) {
			if (!str.equals("")) {
				list.add(str);
			}
		}
        
        // 반환하기
        return list.toArray(new String[list.size()]);
    }
}
