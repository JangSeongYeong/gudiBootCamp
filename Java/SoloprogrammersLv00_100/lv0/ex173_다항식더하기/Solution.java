package lv0.ex173_다항식더하기;

public class Solution {
	/* 한 개 이상의 항의 합으로 이루어진 식을 다항식이라고 합니다. 
	 * 다항식을 계산할 때는 동류항끼리 계산해 정리합니다. 
	 * 
	 * 덧셈으로 이루어진 다항식 polynomial이 매개변수로 주어질 때, 
	 * 동류항끼리 더한 결괏값을 문자열로 return 하도록 solution 함수를 완성해보세요. 
	 * 같은 식이라면 가장 짧은 수식을 return 합니다.*/
    public String solution(String polynomial) {
        // " " 기준으로 나누기
    	String[] opers = polynomial.split(" ");
    	String resultX = "0x";
    	String resultN = "0";
    	
    	for (String str : opers) {
			if(str.equals("+")) continue;
			
			if (str.charAt(str.length()-1) == 'x') {
				// x항끼리 계산
				if(str.substring(0, str.length()-1).equals("")) {
					resultX = Integer.parseInt(resultX.substring(0, resultX.length()-1))+1+"x";
				} else {
					resultX = Integer.parseInt(resultX.substring(0, resultX.length()-1))+Integer.parseInt(str.substring(0, str.length()-1))+"x";
				}
				
			} else {
				// 숫자끼리 계산
				resultN = String.valueOf(Integer.parseInt(str) + Integer.parseInt(resultN));
			}
		}
    	
    	if (resultX.equals("1x")) resultX = "x";
    	
    	String answer = "";
    	if (!resultX.equals("0x")) {
    		answer += resultX;
    		if (!resultN.equals("0")) {
				answer += " + "+resultN;
			}
    	}else {
			answer += resultN;
		}
        
        return answer;
    }
}