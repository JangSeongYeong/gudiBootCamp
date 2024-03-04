package lv01.ex05_자릿수더하기;

public class Solution {
	/* 자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
	 * 예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
	 * N의 범위 : 100,000,000 이하의 자연수 */
    public int solution(int n) {
        int answer = 0;
        // 배열을 씁시다.
        String strn = String.valueOf(n);
        int cnt = 0;
        int val = 0;
        while (cnt < strn.length()) {
        	val = Character.getNumericValue(strn.charAt(cnt));
        	System.out.print(val+" ");
        	answer += val;
        	cnt++;
		}
        System.out.print("= "+answer);

        return answer;
    }
}