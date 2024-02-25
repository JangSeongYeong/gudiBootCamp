package lv0.ex125_숨어있는숫자의덧셈2;

public class Solution {
	/*문자열 my_string이 매개변수로 주어집니다. 
	 * my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. 
	 * my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.*/
	public int solution(String my_string) {
        int answer = 0;
        int save = 0;
        for (int i = 0; i < my_string.length(); i++) {
			// 현재 인덱스가 숫자로 시작하는가?
        	if(Character.isDigit(my_string.charAt(i))){
				// 숫자가 시작하는 idx
				save = i;
				
				// 1개짜리 문자열인데 숫자일경우
				if (my_string.length() == 1) {
					return Integer.parseInt(my_string);
				}
				
				for (int j = i; j < my_string.length(); j++) {
					// 숫자가 끝나는 인덱스를 찾아 그거부터 뒤를 제거하고 숫자를 더하기
					if(!Character.isDigit(my_string.charAt(j)) || j == my_string.length()-1) {
						// 마지막 idx가 숫자로 끝나는경우 대비
						if(Character.isDigit(my_string.charAt(j)) && j == my_string.length()-1) {
							// answer 에 문자열을 숫자로 바꾸어서 대하기 
							answer += Integer.parseInt(my_string.substring(save, j+1));
							// 현재 인덱스 저장하기
							i = j;
							break;
						}
						
						answer += Integer.parseInt(my_string.substring(save, j));
						i = j;
						break;
					}
				}
				
			}
		}
        
        return answer;
    }
}
