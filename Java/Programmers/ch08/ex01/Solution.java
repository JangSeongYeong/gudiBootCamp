package ch08.ex01;

public class Solution {
	
	public String solution(String my_string) {
        String answer = "";
        
        // 1. StringBuilder 활용 0.08~0.11s
//        StringBuffer buffer = new StringBuffer(my_string);
//        answer = buffer.reverse().toString();
        
        // 2. char[] 활용 0.02~0.05
        char[] result = new char[my_string.length()];
       
        for (int i = 0; i < my_string.length(); i++) {
			result[my_string.length()-1-i] = my_string.charAt(i);
		}
        
        answer = new String(result);
        
        return answer;
    }
	
}
