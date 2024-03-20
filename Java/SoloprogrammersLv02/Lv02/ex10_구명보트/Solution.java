package Lv02.ex10_구명보트;

import java.util.Arrays;

public class Solution {
	/* 구명보트는 작아서 한 번에 최대 2명씩 
	 * 
	 * 무게 제한 limit kg
	 * 
	 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
	 * */
	
	/* 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
	 * 각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
	 * 구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
	 * 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 
	    사람들을 구출할 수 없는 경우는 없습니다.*/
    public int solution(int[] people, int limit) {
        // 보트 횟수
    	int answer = 0;
        Arrays.sort(people);
        
        int idx = 0;
        for (int i = people.length-1; i >= idx; i--) {
			if (idx == i) {
				answer++;
				break;
			}
			
			if(people[i] + people[idx] <= limit) {
				answer++;
				idx++;
			} else {
				answer++;
			}
		}
        
        return answer;
    }
}