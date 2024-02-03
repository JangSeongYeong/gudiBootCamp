package ch04.ex03;

public class Solution {
	
	public int[] solution(int money) {
		int[] answer = {0,0};
        
		int coffee = 5500;
        
        answer[0] = money / coffee;
        answer[1] = money % coffee;
        
		return answer;
    }
}
