package lv01.ex02콜라문제;

public class Solution {
	/*빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때, 
	 *빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제*/
	
	/*콜라를 받기 위해 마트에 주어야 하는 병 수 a, 
	 *빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 
	 *상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 
	 *상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.*/
	public int solution(int a, int b, int n) {
		int answer = 0;
        int colra = b*(n/a); // 처음 콜라 총 교환 수
        answer += colra;
        int sb = n%a + colra;
        while (true) {
        	if (sb/a == 0) {
				break;
			}
        	
        	answer += b*(sb/a);
        	sb = (sb%a) + (b*(sb/a));
        	
		}
        
        return answer;
    }
}
