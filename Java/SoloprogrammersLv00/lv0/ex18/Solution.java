package lv0.ex18;

public class Solution {
	/*정수가 담긴 리스트 num_list가 주어질 때, 
	 * 리스트의 길이가 11 이상이면 리스트에 있는 
	 * 모든 원소의 합을 10 이하이면 모든 원소의 곱을 
	 * return 하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] num_list) {
        int answer = 0;
        int lng = num_list.length;
        
        if(lng >= 11) {
        	for (int i : num_list) {
        		answer = answer + i;
			}
        } else {
        	for (int i : num_list) {
        		if(answer == 0) {
        			answer = answer + i;
        		} else {
        			answer = answer * i;
				}
			}
		}
        
        return answer;
    }
}
