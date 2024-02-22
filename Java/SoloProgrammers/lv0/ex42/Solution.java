package lv0.ex42;

import java.util.ArrayList;

public class Solution {
	/*정수 n과 k가 주어졌을 때, 1 이상 n이하의 정수 중에서 k의 배수를 
	 * 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.*/
	public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
       
        // 1이상 n이하 k배수 리스트 저장
        for (int i = 1; i <= n; i++) {
			if (i%k == 0) {
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
