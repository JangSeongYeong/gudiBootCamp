package lv01.ex46_명예의전당1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/* 매일 1명의 가수가 노래를 부르고 
	 * 
	 * 매일 출연한 가수의 점수가 지금까지 출연 가수들의 점수 중 
	 * 상위 k번째 이내이면 해당 가수의 점수를 명예의 전당이라는 목록에 올려 기념
	 * 
	 * k일 다음부터는 출연 가수의 점수가 기존의 명예의 전당 목록의 
	 * k번째 순위의 가수 점수보다 더 높으면, 
	 * 출연 가수의 점수가 명예의 전당에 오르게 되고 
	 * 기존의 k번째 순위의 점수는 명예의 전당에서 내려오게 됩니다
	 * 
	 * 명예의 전당 목록의 점수의 개수 k, 
	 * 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때, 
	 * 매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성
	 * 
	 * 3 ≤ k ≤ 100
	 * 7 ≤ score의 길이 ≤ 1,000
	 * 		0 ≤ score[i] ≤ 2,000
	 * */
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        // 추가 후 정렬 후, 마지막 인덱스를 삭제하고 k번째 인원 반환
        for (int i = 0; i < score.length; i++) {
        	list.add(score[i]);				
			Collections.sort(list);
        	if(i < k) {
				answer[i] = list.get(0);
			} else {
				list.remove(0);
				answer[i] = list.get(0);
			}
		}
        
        return answer;
    }
}