package lv0.ex145_문자개수세기;

public class Solution {
	/*알파벳 대소문자로만 이루어진 문자열 my_string이 주어질 때, 
	 * my_string에서 'A'의 개수, 
	 * my_string에서 'B'의 개수,..., 
	 * my_string에서 'Z'의 개수, 
	 * my_string에서 'a'의 개수, 
	 * my_string에서 'b'의 개수,..., 
	 * my_string에서 'z'의 개수를 순서대로 담은 길이 
	 * 52의 정수 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public int[] solution(String my_string) {
        int[] answer = new int[52];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = 0;
		}
        // 알파벳은 총 26자
        for (int i = 0; i < my_string.length(); i++) {
        	if(Character.isUpperCase(my_string.charAt(i))) {
        		// 대문자일 경우 A 65
        		answer[(int)my_string.charAt(i)-65]++;
        	} else {
				// 소문자일 경우 a 97 을 26으로 만들기 위해 -71
        		answer[(int)my_string.charAt(i)-71]++;
			}
		} // 인덱스 수정
        
        return answer;
    }
}
