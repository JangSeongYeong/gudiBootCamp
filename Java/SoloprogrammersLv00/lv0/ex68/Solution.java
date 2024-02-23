package lv0.ex68;
// 배열의 원소 삭제하기
import java.util.ArrayList;

public class Solution {
	/*정수 배열 arr과 delete_list가 있습니다. 
	 * arr의 원소 중 delete_list의 원소를 모두 삭제하고 남은 원소들은 
	 * 기존의 arr에 있던 순서를 유지한 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public int[] solution(int[] arr, int[] delete_list) {
        // arr를 list화 하여 list에 값을 넣는다.
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 배열을 리스트로
        for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
		}
        
        // 안에 있으면 지우기
        for (int i : delete_list) {
        	if (list.contains(i)) {
        		list.remove(Integer.valueOf(i));				
			}
		}
        // 정리한 배열
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
