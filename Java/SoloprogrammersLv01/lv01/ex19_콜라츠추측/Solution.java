package lv01.ex19_콜라츠추측;

public class Solution {
	/* 1-1. 입력된 수가 짝수라면 2로 나눕니다. 
	 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
	 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다.  
	 * 
	 * 위 작업을 몇 번이나 반복해야 하는지 반환하는 함수, solution을 완성해 주세요. 
	 * 단, 주어진 수가 1인 경우에는 0을, 
	 * 작업을 500번 반복할 때까지 1이 되지 않는다면 –1을 반환
	 */
    public int solution(int num) {
    	int cnt = 0;
        Long lnum = (long)num;
        for (int i = 0; i < 500; i++) {
        	if (lnum == 1) {
				return cnt;
			}
        	
        	if(lnum % 2 == 0) {
        		lnum /= 2;
        		cnt++;
        	} else {
				lnum = lnum*3+1;
				cnt++;
        	}
        }
        
        return -1;
    }
}