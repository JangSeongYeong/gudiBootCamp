package lv0.ex153_문자열여러번뒤집기;

public class Solution {
	/*문자열 my_string과 이차원 정수 배열 queries가 매개변수로 주어집니다. 
	 * queries의 원소는 [s, e] 형태로, 
	 * my_string의 인덱스 s부터 인덱스 e까지를 뒤집으라는 의미입니다. 
	 * my_string에 queries의 명령을 순서대로 처리한 후의 
	 * 문자열을 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        char[] clist = my_string.toCharArray();
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < queries.length; i++) {
        	for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				buffer.append(clist[j]);
			}
        	buffer.reverse();
        	answer = buffer.toString();
        	for (int j = queries[i][0]; j <= queries[i][1]; j++) {
				clist[j] = answer.charAt(j-queries[i][0]);
			}
    		buffer.delete(0, buffer.length());
        }
        
        for (int i = 0; i < clist.length; i++) {
			buffer.append(clist[i]);
		}
        
        return buffer.toString();
    }
}
