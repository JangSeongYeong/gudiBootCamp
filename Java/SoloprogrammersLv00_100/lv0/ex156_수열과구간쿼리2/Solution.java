package lv0.ex156_수열과구간쿼리2;

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
		int[] answer = new int[queries.length];
		
		
        
        return answer;
    }
}

class Solution1 {
	/*정수 배열 arr와 2차원 정수 배열 queries이 주어집니다. 
	 * queries의 원소는 각각 하나의 query를 나타내며, [s, e, k] 꼴입니다.
	 * 
	 * 각 query마다 순서대로 s ≤ i ≤ e인 모든 i에 대해 
	 * k보다 크면서 가장 작은 arr[i]를 찾습니다.
	 * 
	 * 각 쿼리의 순서에 맞게 답을 저장한 배열을 반환하는 solution 함수를 완성해 주세요.
	 * 단, 특정 쿼리의 답이 존재하지 않으면 -1을 저장합니다.*/
	public int[] solution(int[] arr, int[][] queries) {
		int[] answer = new int[queries.length];
		// 전부 0 넣어주기
		for (int i = 0; i < answer.length; i++) {
			answer[i] = 0;
		}
		
		System.out.println(queries.length);
        for (int i = 0; i < queries.length; i++) {
        	// k가 0일때
        	if (queries[i][0] == 0 && queries[i][2] == 0) {
        		continue;
        	}
        	for (int j = queries[i][0]; j <= queries[i][1]; j++) {
        		if (arr[j] > queries[i][2]) { // k보다 큰지 비교
					answer[i] = arr[j];
				}else if (arr[j] < answer[i] && answer[i] != 0 && arr[j] > queries[i][2]) {
					answer[i] = arr[j]; // 값이 추가 된 상태에서 더 작은 값 발견시
				} else if (j == queries[i][1] && answer[i] == 0){
					answer[i] = -1; // 마지막까지 없다면 -1 리턴
				}
			}
		}
        
        return answer;
    }
}