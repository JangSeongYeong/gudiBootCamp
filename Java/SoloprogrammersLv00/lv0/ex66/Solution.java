package lv0.ex66;
// n개 간격의 원소들
import java.util.ArrayList;

public class Solution {
	/*정수 리스트 num_list와 정수 n이 주어질 때, 
	 * num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 
	 * 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 첫번 째 원소는 고정으로 add
        list.add(num_list[0]);
        int count = 1;
        
        // n개 간격으로 저장
        for (int i = 1; i < num_list.length; i++) {
        	if (count == n) {
				list.add(num_list[i]);
				count = 0;
			}
        	count++;
		}
        
        // int 배열로 전환
        int[] answer  = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
