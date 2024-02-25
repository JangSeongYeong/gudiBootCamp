package lv0.ex124_가까운수;

import java.util.Arrays;

public class Solution {
	/*정수 배열 array와 정수 n이 매개변수로 주어질 때, 
	 * array에 들어있는 정수 중 n과 가장 가까운 수를 return 하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] array, int n) {
        int answer = 0;
        
        // 오름차순 정렬
        Arrays.sort(array);
        
        
        for (int i = 0; i < array.length; i++) {
			// 값이 n보다 크거나 같으면 출력
        	if (array[i] >= n) {
				answer = i;
				break;
			} else if (i == array.length-1) {
				// 마지막 수까지 작았을 경우 대비
				return array[answer];
			}
		}
        // 여기까지 answer은 인덱스 위치
        if (array[answer] == n || answer == 0 ) {
			// 마지막 수까지 작았을때, n과 같은 수가 나왔을때, 처음부터 큰 수가 나왔을때
        	return array[answer];
		} else {
			// n 보다 큰수(array[answer])가 들어왔을때
			return array[answer] - n >= n - array[answer-1] ? array[answer-1] : array[answer];
		} 
        
    }
}
