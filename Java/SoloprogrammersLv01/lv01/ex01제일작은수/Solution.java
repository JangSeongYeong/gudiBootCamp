package lv01.ex01제일작은수;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	/*정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
	 * 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
	 * 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.*/
	public int[] solution(int[] arr) {
        int[] answer = Arrays.copyOf(arr,arr.length);
        
        // 1개짜리 배열이면 -1 리턴
        if(arr.length == 1) {
        	return new int[] {-1};
        }
        
        // 가장 작은 수
        Arrays.sort(arr);
        int min = arr[0];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : answer) {
			if(i != min) {
				list.add(i);
			}
		}
        
        // 작은수를 제거한 배열
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
        
        return result;
    }
}


