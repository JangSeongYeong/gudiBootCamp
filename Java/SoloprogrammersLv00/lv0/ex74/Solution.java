package lv0.ex74;

import java.util.Arrays;

// 가장 큰 수 찾기
public class Solution {
	/*정수 배열 array 가 매개변수로 주어질 때, 
	 *가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.*/
	public int[] solution(int[] array) {
        // 배열 복사
		int[] answer = Arrays.copyOf(array, array.length+1);
        
        // 정렬
        Arrays.sort(answer);
        
        // 가장 큰 정수
        int max = answer[answer.length-1];
        int maxidx = Arrays.binarySearch(array, max);
                
        answer = new int[] {max, maxidx};
        
        return answer;
    }
}
