package lv0.ex172_특이한정렬_미완;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	/* 정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다. 
	 * 이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다. 
	 * 정수가 담긴 배열 numlist와 정수 n이 주어질 때 
	 * numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록 solution 함수를 완성해주세요.*/
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Arrays.sort(numlist);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < numlist.length; i++) {
			list.add(String.valueOf(numlist[i]));
		}
        int lear = 10001; // 현재 가장 가까운 작은 값을 넣을 변수
        int num = 0; 		  // 현재 i 에 해당하는 num 값을 저장할 변수 선언
        // 차이가 가장 작은 값을 추가하고 삭제 (정렬 되어있기에 
        for (int i = 0; i < answer.length; i++) {
        	for (int j = 0; j < list.size(); j++) {
        		num = Integer.parseInt(list.get(j));
        		lear = Math.abs(lear - n) >= Math.abs(num - n) ? num : lear; 				
			}
        	answer[i] = lear;
        	list.remove(String.valueOf(lear));
        	lear = 10001;
		}
        
        return answer;
    }
}