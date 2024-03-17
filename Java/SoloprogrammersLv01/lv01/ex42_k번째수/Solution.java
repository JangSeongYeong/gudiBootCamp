package lv01.ex42_k번째수;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/* 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], 
	 * i = 2, j = 5, k = 3이라면 -> 인덱스가 아님 1부터 시작
	 * 
	 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	 * 2에서 나온 배열의 3번째 숫자는 5입니다.*/
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < commands.length; i++) {
			// 잘라서 list 에 넣기
        	for (int j = commands[i][0]-1; j < commands[i][1]; j++) {
				list.add(array[j]);
			}
        	// 정렬
			Collections.sort(list);
			
			// k번째 가져오기
			answer[i] = list.get(commands[i][2]-1);
			
			// 다음 리스를 위해서 비우기
			list.clear();
		}
        
        return answer;
    }
}