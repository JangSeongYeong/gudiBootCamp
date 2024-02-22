package lv0.ex58;
// 특정한 문자를 대문자로 바꾸기
public class Solution {
	/*영소문자로 이루어진 문자열 my_string과 영소문자 1글자로 이루어진 문자열 
	 * alp 가 매개변수로 주어질 때, my_string에서 alp 에 해당하는 모든 글자를 
	 * 대문자로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String my_string, String alp) {
      
        char c = alp.charAt(0);
        String answer = my_string.replace(c, Character.toUpperCase(c));
        
        return answer;
    }
}
