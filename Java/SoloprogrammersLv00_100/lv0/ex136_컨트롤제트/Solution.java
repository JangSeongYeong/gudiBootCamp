package lv0.ex136_컨트롤제트;

public class Solution {
	/*숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 
	 * 문자열에 있는 숫자를 차례대로 더하려고 합니다. 
	 * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다. 
	 * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.*/
	public int solution(String s) {
        int answer = 0;
        
        // 공백 기준 나누기
        String[] slist = s.split(" ");
        
        // Z가 아니면 더하기 Z면 이전 인덱스값 빼기
        for (int i = 0; i < slist.length; i++) {
        	if (!slist[i].equals("Z")) {
				answer += Integer.parseInt(slist[i]);
			} else {
				answer -= Integer.parseInt(slist[i-1]);
			}
		}
        
        return answer;
    }
}
