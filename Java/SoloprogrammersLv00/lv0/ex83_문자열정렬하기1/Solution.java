package lv0.ex83_문자열정렬하기1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/*문자열 my_string이 매개변수로 주어질 때, 
	 * my_string 안에 있는 숫자만 골라 오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.*/
	public int[] solution(String my_string) {
        int[] answer = {};
        // 배열로 만들기
        char[] clist = my_string.toCharArray();
        
        // 숫자만빼내기
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (char c : clist) {
			if(Character.isDigit(c)){
				list.add(Character.getNumericValue(c));
			}
		}
        
        // 정렬하기
        Collections.sort(list);
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        // 반환
        return answer;
    }
}
