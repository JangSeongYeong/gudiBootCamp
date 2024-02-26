package lv0.ex128_배열의길이를2의거듭제곱으로만들기;

public class Solution {
	/*정수 배열 arr이 매개변수로 주어집니다. 
	 * arr의 길이가 2의 정수 거듭제곱이 되도록 arr 뒤에 
	 * 정수 0을 추가하려고 합니다.  2 4 8 16 32
	 * arr에 최소한의 개수로 0을 추가한 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public int[] solution(int[] arr) {
        int[] answer = {};
        
        int length = 1;
        while (arr.length > length) {
			length *= 2;
		}
        
        answer = new int[length];
        
        for (int i = 0; i < answer.length; i++) {
        	if(i < arr.length) {
        		answer[i] = arr[i];
        	} else {
				answer[i] = 0;
			}
		}
        
        return answer;
    }
}
