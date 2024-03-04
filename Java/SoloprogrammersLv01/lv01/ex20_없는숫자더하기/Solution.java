package lv01.ex20_없는숫자더하기;

public class Solution {
	/* 0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
	 * 
	 *  numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return */
    public int solution(int[] numbers) {
        int answer = 0;
        
        String num = "1234567890";
        
        String str;
        for (int i = 0; i < numbers.length; i++) {
			str = String.valueOf(numbers[i]);
        	num = num.replace(str, "0");
		}
        
        for (int i = 0; i < num.length(); i++) {
			answer += Character.getNumericValue(num.charAt(i));
		}
        return answer;
    }
}