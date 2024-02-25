package lv0.ex110_수열과구간쿼리1;

public class Solution {
	/*정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. 
	 * queries의 원소는 각각 하나의 query를 나타내며, [s, e] 꼴입니다.
	 * 
	 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 arr[i]에 1을 더합니다.
	 * 위 규칙에 따라 queries를 처리한 이후의 arr를 return 하는 solution 함수를 완성해 주세요.*/
	public int[] solution(int[] arr, int[][] queries) {
        // queries범위 안에 있는 arr을 1씩 더하기
        for (int i = 0; i < queries.length; i++) {
			for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				arr[j]++;
			}			
		}
        
        return arr;
    }
}
