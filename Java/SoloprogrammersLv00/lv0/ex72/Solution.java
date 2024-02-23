package lv0.ex72;
// 문자열 정수의 합
public class Solution {
	/*한 자리 정수로 이루어진 문자열 num_str이 주어질 때, 
	 *각 자리수의 합을 return하도록 solution 함수를 완성해주세요.*/
	public int solution(String num_str) {
        int answer = 0;
        
        // 문자열 숫자로 변환
        char[] clist = num_str.toCharArray();
        
        // 자리수마다 더해주기
        for (int i = 0; i < clist.length; i++) {
			answer += Character.getNumericValue(clist[i]);
		}
        
        return answer;
    }
}
