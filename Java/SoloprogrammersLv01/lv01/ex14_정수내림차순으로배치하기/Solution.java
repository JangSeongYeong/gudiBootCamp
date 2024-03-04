package lv01.ex14_정수내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
	/* 함수 solution은 정수 n을 매개변수로 입력받습니다. 
	 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 
	 * 예를들어 n이 118372면 873211을 리턴하면 됩니다*/
    public long solution(long n) {
        long answer = 0;
        
        String strn = String.valueOf(n);
        char[] clist = strn.toCharArray();
        Arrays.sort(clist);
        
        
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < clist.length; i++) {
			buffer.append(clist[i]);
		}
        buffer.reverse();

        answer = Long.parseLong(buffer.toString());
        return answer;
    }
}