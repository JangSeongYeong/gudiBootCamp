package lv0.ex75;
// 0 떼기
public class Solution {
	/*정수로 이루어진 문자열 n_str이 주어질 때, 
	 *n_str의 가장 왼쪽에 처음으로 등장하는 0들을 뗀 문자열을 return하도록 solution 함수를 완성해주세요.*/
	public String solution(String n_str) {
        String answer = "";
        int last0idx = 0;
        
        for (int i = 0; i < n_str.length(); i++) {
			if(n_str.charAt(i)=='0') {
				last0idx++;
			} else {
				break;
			};
		}
        
        answer = n_str.substring(last0idx, n_str.length());
        
        return answer;
    }
}
