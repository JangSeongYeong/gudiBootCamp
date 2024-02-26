package lv0.ex143_소인수분해;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	/*소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 
	 * 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 
	 * 따라서 12의 소인수는 2와 3입니다. 
	 * 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요*/
	public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean second = false;
        boolean Third = false; 
        boolean five = false;
 
        while (true) {
			if (n%2 == 0 && n != 2) {
				n = n/2;
				second = true;
				continue;
			}
			
			if (n%3 == 0 && n != 3) {
				n = n/3;
				Third = true;
				continue;
			}
			
			if (n%5 == 0 && n != 5) {
				n = n/5;
				five = true;
				continue;
			}
			
			
			// 제곱근
			if (Math.sqrt(n) % 1 == 0.0) {
				n = (int)Math.sqrt(n);
				list.add(n);
			}
			
			if (second == false || Third == false || five == false || list.size() == 0) {
				list.add(n);
			}
			
			break;
		}
        
        if (second) {
        	list.add(2);
		}
        
        if (Third) {
        	list.add(3);
		}
        
        if (five) {
        	list.add(5);
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
        
        Arrays.sort(answer);
        
        return answer;
    }
}
