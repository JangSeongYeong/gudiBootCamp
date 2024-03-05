package lv01.ex25_가운데글자가져오기;

public class Solution {
	/* 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
	 * 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
	 * 
	 * s는 길이가 1 이상, 100이하인 스트링입니다.*/
    public String solution(String s) {
        // 홀수 - 나누기 2 +1
        // 짝수 - 나누기2~3까지
        int size = s.length();
    	String answer = s.length()%2 !=0 ? String.valueOf(s.charAt(size/2)) : s.substring(size/2-1,size/2+1);
        return answer;
    }
}