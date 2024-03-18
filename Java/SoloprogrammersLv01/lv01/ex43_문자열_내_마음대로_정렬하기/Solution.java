package lv01.ex43_문자열_내_마음대로_정렬하기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	/* 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
	 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
	 * 
	 * 예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 
	 * "u", "e", "a"로 strings를 정렬합니다.*/
	
	/* strings는 길이 1 이상, 50이하인 배열입니다.
	 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
	 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
	 * 모든 strings의 원소의 길이는 n보다 큽니다.
	 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
	 * */
    public String[] solution(String[] strings, int n) {
    	// 먼저 사전 순으로 정렬 (오름차순)
    	Arrays.sort(strings);
    	
    	// 사전 순으로 정렬하고 뒤에서부터 값을 넣게 되면 자연스레 인덱스로 값을 넣을 경우 사전순으로 뒤에 있는것은 뒤로 밀림
        String[] answer = new String[strings.length];
        ArrayList<String> slist = new ArrayList<String>();

        // 문자열의 n 번째 인덱스를 비교하며 현재 Strings[n]이 더 작거나 같다면 현재 비교하고 있는 인덱스에 넣기 
        for (int i = strings.length-1; i >= 0; i--) {
        	int size = slist.size();
        	
        	for (int j = 0; j < slist.size(); j++) {
        		if(strings[i].charAt(n) <= slist.get(j).charAt(n)) {
        			slist.add(j, strings[i]);
        			break;
        		}
        	}
        	if(size == slist.size()) slist.add(strings[i]); // 변동 없으면 마지막에 추가
        	
		}
        
        for (int i = 0; i < answer.length; i++) {
        	answer[i] = slist.get(i);
        }
        
        return answer;
    }
}