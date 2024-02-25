package lv0.ex122_문자열이몇번등장하는지세기;

public class Solution {
	/*문자열 myString과 pat이 주어집니다. 
	 * myString에서 pat이 등장하는 횟수를 return 하는 solution 함수를 완성해 주세요.*/
	public int solution(String myString, String pat) {
        int answer = 0;
        
        while (myString.indexOf(pat) != -1) {
        	answer++;        	
        	myString = myString.substring(myString.indexOf(pat)+1, myString.length());
        	
		}
        
        return answer;
    }
}
