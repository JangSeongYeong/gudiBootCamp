package lv0.ex96_문자열잘라서정렬하기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	/*문자열 myString이 주어집니다. 
	 * "x"를 기준으로 해당 문자열을 잘라내 배열을 만든 후 
	 * 사전순으로 정렬한 배열을 return 하는 solution 함수를 완성해 주세요.
	 * 
	 * 단, 빈 문자열은 반환할 배열에 넣지 않습니다.
		- 사전순 : 오름차순	
	*/
	public String[] solution(String myString) {
        String[] answer = {};
        
        answer = myString.split("x");
        
        Arrays.sort(answer);
        
        // 빈 문자열 제거
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < answer.length; i++) {
			if(!answer[i].equals("")) {
				list.add(answer[i]);
			}
		}
        
        return list.toArray(new String[list.size()]);
    }
}
