package lv0.ex40;

public class Solution {
	/*알파벳으로 이루어진 문자열 myString과 pat이 주어집니다. 
	 * myString의 연속된 부분 문자열 중 pat이 존재하면 1을 
	 * 그렇지 않으면 0을 return 하는 solution 함수를 완성해 주세요.
		단, 알파벳 대문자와 소문자는 구분하지 않습니다.*/
	public int solution(String myString, String pat) {
        int answer = 0;
        // 대소문자를 구분하지 않는다고 했기에 둘다 대문자로 맞춰줍니다.
        String Str = myString.toUpperCase();
        String patUp = pat.toUpperCase();
        if(Str.contains(patUp)) {
        	answer = 1;
        } 
        
        return answer;
    }
}
