package lv01.ex36_이상한문자만들기;

import java.util.*;

public class Solution {
	/* 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
	 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
	 * 각 단어의 짝수번째 알파벳은 대문자로, 
	 * 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
	 * 
	 * 인덱스 기준 x*/
    public String solution(String s) {
        String answer = "";
        // 전부 소문자화
        s = s.toLowerCase();
        
        int cnt = 0;
    	// 마지막 공백 알아내기
    	for (int i = s.length()-1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				cnt++;
			} else {
				break;
			}
		}
        
        
        // " " 기준으로 분리
        String[] slist = s.split(" ");
        System.out.println(Arrays.toString(slist));
        // 홀수 번째 (인덱스로는 짝수번째) 대문자로
        char[] clist;
        for (int i = 0; i < slist.length; i++) {
        	clist = slist[i].toCharArray();
        	for (int j = 0; j < clist.length; j++) {
        		if(j % 2 == 0) clist[j] = Character.toUpperCase(clist[j]);
        	}
        	slist[i] = String.valueOf(clist);
		}
        
        // 문자열로 합치기
        for (int i = 0; i < slist.length; i++) {
        	if (i != slist.length-1) {
				answer += slist[i] + " ";
			} else {
				answer += slist[i];
			}
		}
        
        for (int i = 1; i <= cnt; i++) {
			answer += " ";
		}
        
        return answer;
    }
}