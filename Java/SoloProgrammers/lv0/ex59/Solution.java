package lv0.ex59;
// 문자열 바꿔서 찾기
public class Solution {
	/*문자 "A"와 "B"로 이루어진 문자열 myString과 pat가 주어집니다. 
	 * myString의 "A"를 "B"로, "B"를 "A"로 바꾼 문자열의 연속하는 부분 문자열 중 
	 * pat이 있으면 1을 아니면 0을 return 하는 solution 함수를 완성하세요.*/
	public int solution(String myString, String pat) {
        int answer = 0;
        String resultStr = "";
        // A <-> B
        resultStr = myString.replace("A", "X"); // temp
        resultStr = resultStr.replace("B", "A");
        resultStr = resultStr.replace("X", "B");
        
        // pat 찾기
        if(resultStr.contains(pat)) {
        	answer = 1;
        } else {
			answer = 0;
		}
        
        // return
        return answer;
    }
}
