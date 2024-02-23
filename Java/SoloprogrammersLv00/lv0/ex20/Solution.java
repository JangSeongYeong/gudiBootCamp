package lv0.ex20;

class Solution {
	/*문자열 my_string과 정수 n 이 매개변수로 주어질 때, 
	 * my_string의 앞의 n 글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.*/
    public String solution(String my_string, int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < n; i++) {
			buffer.append(my_string.charAt(i));
		}
        
        return buffer.toString();
    }
}