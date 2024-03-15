package lv01.ex40_가장가까운같은글자;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	/* 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 
	 * "자신과 가장 가까운 곳"에 있는 같은 글자가 어디 있는지 알고 싶습니다.
	 * 
	 * 처음 나온 문자면 -1 나온적이 있는 문자라면 그 몇칸 앞에 있는지 표현
	 * */
    public int[] solution(String s) {
        
        // map
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        String[] slist = s.split("");
        int[] answer = new int[slist.length];
        System.out.println(Arrays.toString(slist));
        
        // map에 특정키가 있으면 계산 없으면 -1을 반환한 뒤 추가
        for (int i = 0; i < slist.length; i++) {
			if(!map.containsKey(slist[i])) {
				answer[i] = -1;
			} else {
				answer[i] = i - map.get(slist[i]);
			}
			map.put(slist[i], i);
		}
        
        return answer;
    }
}