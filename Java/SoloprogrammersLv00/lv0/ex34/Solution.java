package lv0.ex34;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	/*정수 n과 정수 배열 numlist가 매개변수로 주어질 때, 
	 * numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i : numlist) {
			if (i%n ==0) {
				list.add(i);
			}
		}
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
		}
        
        
        return answer;
    }
}
