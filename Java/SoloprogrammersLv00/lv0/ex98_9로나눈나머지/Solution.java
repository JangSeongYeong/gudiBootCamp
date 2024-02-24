package lv0.ex98_9로나눈나머지;

public class Solution {
	/*음이 아닌 정수를 9로 나눈 나머지는 그 정수의 각 자리 숫자의 합을 
	 * 9로 나눈 나머지와 같은 것이 알려져 있습니다.
	 * 
	 * 이 사실을 이용하여 음이 아닌 정수가 문자열 number로 주어질 때, 
	 * 이 정수를 9로 나눈 나머지를 return 하는 solution 함수를 작성해주세요.*/
	public int solution(String number) {
        int answer = 0;
		
		char[] clist = new char[number.length()];
		
		clist = number.toCharArray();
		
        for (int i = 0; i < clist.length; i++) {
			answer += Character.getNumericValue(clist[i]);
        }
		
        return answer%9;
    }
}
