package lv0.ex88_배열만들기3;

import java.util.ArrayList;

public class Solution {
	/*정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
	 * intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 
	 * 각 구간은 닫힌 구간입니다. 
	 * 
	 * 닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
	 * 
	 * 이때 배열 arr의 첫 번째 구간에 해당하는 배열과 
	 * 두 번째 구간에 해당하는 배열을 앞뒤로 붙여 새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.*/
	
	public int[] solution(int[] arr, int[][] intervals) {
    
        // 리스트를 통해서 배열에 연결하며 축가
        // 선언
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 첫번째 구간, 두번쨰 구간 추가하기 (for 2로 분리 했다가 합침)
        for (int i = 0; i < 2; i++) {
        	for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
    			list.add(arr[j]);
    		}
		}
        
        // 반환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        return answer;
    }
}
