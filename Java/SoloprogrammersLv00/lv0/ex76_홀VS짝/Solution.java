package lv0.ex76_홀VS짝;
// 홀수 VS 짝수
public class Solution {
	/*정수 리스트 num_list가 주어집니다. 
	 * 가장 첫 번째 원소를 1번 원소라고 할 때, 
	 * 홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요. 두 값이 같을 경우 그 값을 return합니다.*/
	public int solution(int[] num_list) {
        int oodsum = 0;
        int evensum =0;
        // 짝수 인덱스가 홀수 원소, 홀수 인덱스가 짝수 원소
        for (int i = 0; i < num_list.length; i++) {
			if(i % 2 == 0) {
				oodsum += num_list[i];
			} else {
				evensum += num_list[i];
			}
		}
        
        if(oodsum >= evensum) {
        	return oodsum;
        } else {
			 return evensum;
		}        
    }
}
