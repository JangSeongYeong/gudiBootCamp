package lv0.ex127_진료순서정하기;

import java.util.Arrays;

public class Solution {
	/*외과의사 머쓱이는 응급실에 온 환자의 응급도를 기준으로 
	 * 진료 순서를 정하려고 합니다. 
	 * 
	 * 정수 배열 emergency가 매개변수로 주어질 때 
	 * 응급도가 높은 순서대로 진료 순서를 정한 배열을 return하도록 solution 함수를 완성해주세요.*/
	
	// 크면 순위가 높아지는 것 [3,76,24] [3순위 1순위 2순위]
	public int[] solution(int[] emergency) {
        
		int[] answer = Arrays.copyOf(emergency, emergency.length);
        
        // 정렬
        Arrays.sort(emergency);
        // 뒤집기
        int[] temp = new int[emergency.length];
        int count = emergency.length-1;
        for (int i = 0; i < emergency.length; i++) {
			temp[i] = emergency[count];
			count--;
		}

        // 순위 구하기
        for (int i = 0; i < answer.length; i++) {
        	for (int j = 0; j < temp.length; j++) {
				if (answer[i] == temp[j]) {
					answer[i] = j+1;
					break;
				}
			}
        }
        
        return answer;
    }
}
