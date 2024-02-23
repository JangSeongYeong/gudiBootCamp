package lv0.ex65;
// 부분 문자열 이어 붙여 문자열 만들기

public class Solution {
	/*길이가 같은 문자열 배열 my_strings와 이차원 정수 배열 parts가 매개변수로 주어집니다. 
	 * parts[i]는 [s, e] 형태로, 
	 * my_string[i]의 인덱스 s부터 인덱스 e까지의 부분 문자열을 의미합니다. 
	 * 
	 * 각 my_strings의 원소의 parts에 해당하는 부분 문자열을 
	 * 순서대로 이어 붙인 문자열을 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String[] my_strings, int[][] parts) {
        // 문자 더하기는 버퍼
		StringBuffer buffer = new StringBuffer();
		
		// 2차원 배열에 맞춰서 자르고 더하기
		for (int i = 0; i < my_strings.length; i++) {
			buffer.append(my_strings[i].substring(parts[i][0], parts[i][1]+1));
		}
        
		// 문자열 반환
        return buffer.toString();
    }
}
