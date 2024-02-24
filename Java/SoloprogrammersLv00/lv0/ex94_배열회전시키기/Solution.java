package lv0.ex94_배열회전시키기;

public class Solution {
	/*정수가 담긴 배열 numbers와 문자열 direction가 
	 * 매개변수로 주어집니다. 
	 * 배열 numbers의 원소를 direction방향으로 한 칸씩 회전시킨 
	 * 배열을 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if(direction.equals("right")) {
        	// right 일 경우 오른쪽으로 회전 
        	answer[0] = numbers[numbers.length-1];
        	for (int i = 1; i < answer.length; i++) {
				answer[i] = numbers[i-1];
			}       	
        } else {
			// left 일 경우 왼쪽으로 회전
        	for (int i = 1; i < answer.length; i++) {
				answer[i-1] = numbers[i];
			} 
        	answer[numbers.length-1] = numbers[0];
		}
        
        return answer;
    }
}
