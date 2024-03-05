package lv01.ex21_나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/* array의 각 element 중 divisor로 나누어 떨어지는 값을 
	 * 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	 * 
	 * divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.*/
    public int[] solution(int[] arr, int divisor) {
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();

    	for (int i = 0; i < arr.length; i++) {
			if(arr[i]%divisor == 0) list.add(arr[i]);
		}
    	
    	if (list.size() == 0) return new int[] {-1};
    	
    	Collections.sort(list);
    	
    	int[] answer = new int[list.size()];
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}