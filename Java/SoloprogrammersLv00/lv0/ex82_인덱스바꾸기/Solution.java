package lv0.ex82_인덱스바꾸기;

public class Solution {
	/*문자열 my_string과 정수 num1, num2가 매개변수로 주어질 때, 
	 * my_string에서 인덱스 num1과 인덱스 num2에 해당하는 
	 * 문자를 바꾼 문자열을 return 하도록 solution 함수를 완성해보세요.*/
	public String solution(String my_string, int num1, int num2) {
        // 배열화
        char[] clist = my_string.toCharArray();
        
        // 교환
        char temp = clist[num1];
        clist[num1] = clist[num2];
        clist[num2] = temp;
        
        // 문자열 생성
        StringBuffer buffer = new StringBuffer();
        for (char c : clist) {
			buffer.append(c);
		}
        // 리턴
        return buffer.toString();
    }
}
