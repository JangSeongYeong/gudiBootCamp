package lv0.ex80_최댓값만들기2;

import java.util.Arrays;

public class Solution {
	/*정수 배열 numbers가 매개변수로 주어집니다. 
	 * numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] numbers) {
        
        Arrays.sort(numbers);
        
        int pp = numbers[numbers.length-1]*numbers[numbers.length-2];
        int mm = numbers[0]*numbers[1];
        
        if(pp > mm) {
        	return pp;
        } else {
			return mm;
		}
    }
}
