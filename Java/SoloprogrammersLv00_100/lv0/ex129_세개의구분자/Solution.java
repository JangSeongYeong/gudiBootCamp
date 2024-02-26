package lv0.ex129_세개의구분자;

import java.util.ArrayList;

public class Solution {
	/*임의의 문자열이 주어졌을 때 문자 "a", "b", "c"를 구분자로 
	 * 사용해 문자열을 나누고자 합니다.
	 * 
	 * 예를 들어 주어진 문자열이 "baconlettucetomato"라면 
	 * 나눠진 문자열 목록은 ["onlettu", "etom", "to"] 가 됩니다.
	 * 
	 * 문자열 myStr이 주어졌을 때 
	 * 위 예시와 같이 "a", "b", "c"를 사용해 나눠진 문자열을 
	 * 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
	 * 
	 * 단, 두 구분자 사이에 다른 문자가 없을 경우에는 
	 * 아무것도 저장하지 않으며, 
	 * return할 배열이 빈 배열이라면 ["EMPTY"]를 return 합니다.*/
	public String[] solution(String myStr) {
        String[] answer = {};
        ArrayList<String> list = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        
        // 문자열을 문자열 배열로
        answer = myStr.split("");
        
        // 하나씩 비교하며 a, b, c가 아니라면 buffer에 더하기
        for (int i = 0; i < answer.length; i++) {
			if(!answer[i].equals("a") && !answer[i].equals("b") && !answer[i].equals("c")) {
				buffer.append(answer[i]);
			} else {
				// 맞다면 내려와
				if(!buffer.toString().equals("")) {
					list.add(buffer.toString());
					buffer.delete(0, buffer.toString().length());
				}
			}
			
			if (i == answer.length-1 && !buffer.toString().equals("")) {
				list.add(buffer.toString());
			}
			
		}
        if(list.isEmpty()) {
        	return new String[] {"EMPTY"};
        }
        
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        
        return answer;
    }
}
