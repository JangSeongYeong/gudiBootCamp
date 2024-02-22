package lv0.ex48;

import java.util.Arrays;

public class Solution {
	/*정수로 이루어진 리스트 num_list가 주어집니다.
	 * num_list에서 가장 작은 5개의 수를 제외한 수들을 
	 * 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
		int[] answer = new int[num_list.length-5];
        for (int i = 0; i < num_list.length-5; i++) {
			answer[i] = num_list[i+5];
		}
		
        return answer;
    }
}
