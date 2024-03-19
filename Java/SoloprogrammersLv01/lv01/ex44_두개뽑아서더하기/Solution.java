package lv01.ex44_두개뽑아서더하기;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
	/* 정수 배열 numbers가 주어집니다. 
	 * numbers에서 서로 다른 인덱스에 있는 
	 * 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 
	 * solution 함수를 완성해주세요.*/
	
	/* numbers.length : 2~100, number[n] : 0~100 */
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
        
        int[] answer = new int[set.size()];
        int cnt = 0;
        for (int i : set) {
			answer[cnt] = i;
			cnt++;
		}

        Arrays.sort(answer);
        
        return answer;
    }
}