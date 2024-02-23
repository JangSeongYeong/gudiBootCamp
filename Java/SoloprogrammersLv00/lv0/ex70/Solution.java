package lv0.ex70;

// x 사이의 개수
public class Solution {
	/*문자열 myString이 주어집니다. 
	 * myString을 문자 "x"를 기준으로 나눴을 때 나눠진 
	 * 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.*/
	public int[] solution(String myString) {        
        // x기준으로 나누기 , 마지막에 X가 있을 경우 나눠지지 않음
		String[] strlist = myString.split("x");
		
		int[] answer = {};
		// x가 마지막에 있을때를 대비
		if(myString.charAt(myString.length()-1) == 'x') {
			answer = new int[strlist.length+1];
		} else {
			answer = new int[strlist.length];
		};
		// string 세기
        for (int i = 0; i < strlist.length; i++) {
			if (strlist[i] != null) {
				answer[i] = strlist[i].length();
			} else {
				answer[i] = 0;
			}
		}
        
        // return 하기
        return answer;
    }
}
