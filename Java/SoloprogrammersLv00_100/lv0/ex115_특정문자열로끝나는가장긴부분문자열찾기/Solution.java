package lv0.ex115_특정문자열로끝나는가장긴부분문자열찾기;

public class Solution {
	/*문자열 myString과 pat가 주어집니다. 
	 * myString의 부분 문자열중 pat로 끝나는 가장 긴 부분 문자열을 찾아서 return 하는 solution 함수를 완성해 주세요.*/
	public String solution(String myString, String pat) {  
        return myString.substring(0,myString.lastIndexOf(pat)+pat.length());
    }
}
