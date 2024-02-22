package lv0.ex52;

import java.util.Arrays;

// 배열의 길이에 따라 다른 연산하기
public class Solution {
	/*정수 배열 arr과 정수 n이 매개변수로 주어집니다. 
	 * arr의 길이가 홀수라면 arr의 모든 짝수 인덱스 위치에 n을 더한 배열을, 
	 * arr의 길이가 짝수라면 arr의 모든 홀수 인덱스 위치에 n을 더한 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public int[] solution(int[] arr, int n) {
        int[] answer = Arrays.copyOf(arr, arr.length);
        
        // 홀짝 구분
        if (arr.length % 2 == 0) { // 짝수
			for (int i = 0; i < answer.length; i++) {
				if(i%2 != 0) {
					answer[i] += n;
				}
			}
        } else { // 홀수
        	for (int i = 0; i < answer.length; i++) {
				if(i%2 == 0) {
					answer[i] += n;
				}
			}
		}
        
        return answer;
    }
}
