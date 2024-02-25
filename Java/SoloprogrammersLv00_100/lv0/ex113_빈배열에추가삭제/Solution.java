package lv0.ex113_빈배열에추가삭제;

import java.util.ArrayList;

public class Solution {
	/*아무 원소도 들어있지 않은 빈 배열 X가 있습니다. 
	 * 길이가 같은 정수 배열 arr과 boolean 배열 flag가 매개변수로 주어질 때,
	 * flag를 차례대로 순회하며 
	 * flag[i]가 true라면 X의 뒤에 arr[i]를 arr[i] × 2 번 추가하고, 
	 * flag[i]가 false라면 X에서 마지막 arr[i]개의 원소를 제거한 뒤 X를 return 하는 solution 함수를 작성해 주세요*/
	public int[] solution(int[] arr, boolean[] flag) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < flag.length; i++) {
			if (flag[i]) {
				for (int j = 1; j <= arr[i]*2; j++) {
					list.add(arr[i]);
				}
			} else {
				for (int j = 1; j <= arr[i]; j++) {
					list.remove(list.size()-1);
				}
			}
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
