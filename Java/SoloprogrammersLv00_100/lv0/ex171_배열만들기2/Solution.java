package lv0.ex171_배열만들기2;

public class Solution {
	/* 정수 l과 r이 주어졌을 때, 
	 * l 이상 r이하의 정수 중에서 숫자 "0"과 "5"로만 이루어진 모든 정수를 
	 * 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
	 * 
	 * 만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.*/
    public int[] solution(int l, int r) {
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("5");
    	
    	while (Integer.parseInt(buffer.toString()) < l) {
    		buffer.append("0");
		}
    	
    	
        
    	int[] answer = {};
        return answer;
    }
}