package lv0.ex112_문자열뒤집기;

public class Solution {
	/*문자열 my_string과 정수 s, e가 매개변수로 주어질 때, 
	 *my_string에서 인덱스 s부터 인덱스 e까지를 뒤집은 문자열을 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String my_string, int s, int e) {
        
        StringBuffer buffer = new StringBuffer(my_string.substring(s, e+1));
        String answer = buffer.reverse().toString();
        
        buffer = new StringBuffer(my_string.substring(0, s));
        buffer.append(answer);
        buffer.append(my_string.substring(e+1,my_string.length()));
        
        return buffer.toString();
    }
}
