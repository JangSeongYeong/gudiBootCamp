package ch02.ex06;

public class Solution {
	public int solution(int n, int k) {
		// 인원 n, 양꼬치 12000, 음료수 2000, 음료수 k, 
        int answer = 0;
        int drink = 2000;
        
        answer = 12000*n + drink*k - n/10*drink;        
        return answer;
    }
}
