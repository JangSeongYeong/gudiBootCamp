package lv0.ex90_약수구하기;

import java.util.ArrayList;

public class Solution {
	/*정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int n) {
        
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        // 나머지가 0이면 약수
        for (int i = 1; i <= n; i++) {
			if(n % i == 0) {
				nlist.add(i);
			}
		}
        
        // 배열로 변환
        int[] answer = new int[nlist.size()];
        
        for (int i = 0; i < nlist.size(); i++) {
			answer[i] = nlist.get(i);
		}
        
        return answer;
    }
}
