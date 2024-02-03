package ch04.ex02;

public class Solution {
	
	public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int Odd = 0;
        int Even = 0;
        
        for (int i = 0; i < num_list.length; i++) {
			if(num_list[i]%2 == 0) {
				Even++;
			} else {
				Odd++;
			}
		}
        
        answer[0] = Even;
        answer[1] = Odd;
        
        return answer;
    }
}
