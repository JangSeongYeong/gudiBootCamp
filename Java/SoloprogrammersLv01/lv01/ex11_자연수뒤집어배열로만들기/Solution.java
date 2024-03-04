package lv01.ex11_자연수뒤집어배열로만들기;

import java.util.ArrayList;

public class Solution {
	/*자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
	 * 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.*/
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (n/10 >= 1) {
			list.add((int)(n%10));
			n /= 10;
		}
        list.add((int)n);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
        return answer;
    }
}