package lv0.ex158_문자열겹쳐쓰기;

public class Solution {
	/* 문자열 my_string, overwrite_string과 정수 s가 주어집니다. 
	 * 문자열 my_string의 인덱스 s부터 overwrite_string의 길이만큼을 
	 * 문자열 overwrite_string으로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.*/
    public String solution(String my_string, String overwrite_string, int s) {
        
        StringBuffer buffer = new StringBuffer();
        buffer.append(my_string.substring(0, s));
        buffer.append(overwrite_string);
        buffer.append(my_string.substring(s+overwrite_string.length()));
        
        return buffer.toString();
    }
}