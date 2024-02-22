package lv0.ex37;

public class Solution {
	/*정수가 담긴 리스트 num_list가 주어집니다. 
	 * num_list의 홀수만 순서대로 이어 붙인 수와 짝수만 순서대로 
	 * 이어 붙인 수의 합을 return하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] num_list) {
        int answer = 0;
        StringBuffer oddBuffer = new StringBuffer();
        StringBuffer evenBuffer = new StringBuffer();
        
        // 홀짝으로 나눠서 합치기
        for (int i : num_list) {
			if(i%2 == 0) {
				evenBuffer.append(i);
			} else {
				oddBuffer.append(i);
			}
		}
        
        String oddStr = oddBuffer.toString();
        String evenStr = evenBuffer.toString();
        
        // 숫자로 변환
        int oddInt = Integer.parseInt(oddStr);
        int evenInt = Integer.parseInt(evenStr);
        // 더하기
        answer = oddInt + evenInt;
        
        return answer;
    }
}
