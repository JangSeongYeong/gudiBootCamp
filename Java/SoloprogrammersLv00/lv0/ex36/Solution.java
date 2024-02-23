package lv0.ex36;

public class Solution {
	/*정수 리스트 num_list가 주어질 때, 
	 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 
	 * 그전 원소를 뺀 값을 마지막 원소가 그전 원소보다 크지 않다면 
	 * 마지막 원소를 두 배한 값을 추가하여 return하도록 solution 함수를 완성해주세요.*/
	
	public int[] solution(int[] num_list) {
		
		int[] answer = new int[num_list.length+1];
        
		for (int i = 0; i < num_list.length; i++) {
			answer[i] = num_list[i];
		}
		
		
        if (num_list[num_list.length-1] > num_list[num_list.length-2]) {
        	answer[answer.length-1] = num_list[num_list.length-1] - num_list[num_list.length-2];
		} else {
			answer[answer.length-1] = num_list[num_list.length-1]*2;
		}
        
        return answer;
    }
}
