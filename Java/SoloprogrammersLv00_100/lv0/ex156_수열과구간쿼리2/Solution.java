package lv0.ex156_수열과구간쿼리2;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/*정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. 
	 * queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
	 * 
	 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 
	 * k보다 크면서 가장 작은 arr[i]를 찾습니다.
	 * 
	 * 각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
	 * 단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.*/
	public int[] solution(int[] arr, int[][] queries) {
		// queries[n][0] 보다 크거나 같고 queries[n][1] 보다 작거나 같으면서
		// queries[n][2] 보다 크면서 가장 작은 값
		int[] answer = new int[queries.length];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		// 범위 만큼 리스트 생성
		for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				list.add(arr[j]);
			}
			// 생성한 리스트 정렬
			Collections.sort(list);
			
			// 리스트에서 k보다 큰 값 넣기
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j) > queries[i][2]) {
					// 가장 먼저 나온 queries[n][2] 보다 큰 값을 출력
					answer[i] = list.get(j);
					break;
				}
				
				if(j == list.size()-1) answer[i] = -1;
			}
			
			list.clear();
		}
        
        return answer;
    }
}