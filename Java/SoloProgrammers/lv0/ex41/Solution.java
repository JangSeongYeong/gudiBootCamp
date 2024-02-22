package lv0.ex41;

public class Solution {
	/*정수가 담긴 리스트 num_list가 주어질 때, 
	 * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 
	 * 크면 0을 return하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] num_list) {
        int answer = 0;
        
        int sum = 0;
        int mul = 0;
        
        for (int i = 0; i < num_list.length; i++) {
        	sum += num_list[i];
        	if (i == 0) {
				mul += num_list[i];
			} else {
				mul *= num_list[i];
			}
		}
        
        if (sum*sum>mul) {
			answer = 1;
		} 
        
        return answer;
    }
}
