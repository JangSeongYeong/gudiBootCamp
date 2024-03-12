package lv0.ex171_배열만들기2;

import java.util.ArrayList;

public class Solution {
	/* 정수 l과 r이 주어졌을 때, 
	 * l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 
	 * 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
	 * 
	 * 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.*/
    public int[] solution(int l, int r) {
    	String[] arr = {"2","3","4","5","6","7","8","9"};
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	StringBuffer buffer = new StringBuffer();
    	
    	String innum = "";
    	for (int i = l; i <= r; i++) {
    		// i 를 5로 나눴을때 1, 0 이외의 숫자가 들어가면 넘기기 다른 수임 
    		buffer.append(i/5);
    		innum = buffer.toString();
    		for (int j = 0; j < arr.length; j++) {
				 innum = innum.replace(arr[j], "");
			}
    		
    		if(innum.length() == buffer.length() && i%5 == 0) list.add(i);
    		buffer.delete(0, buffer.length());
    	}
    	
    	if (list.size() == 0) return new int[] {-1}; 
        
    	int[] answer = new int[list.size()];
    	
    	for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
    	
        return answer;
    }
}