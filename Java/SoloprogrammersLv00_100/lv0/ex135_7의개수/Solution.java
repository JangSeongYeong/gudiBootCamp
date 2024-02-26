package lv0.ex135_7의개수;

public class Solution {
	/*머쓱이는 행운의 숫자 7을 가장 좋아합니다. 
	 * 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.*/
	public int solution(int[] array) {
        int answer = 0;
        
        StringBuffer buffer = new StringBuffer();

        for (int i : array) {
			buffer.append(i);
		}
        
        String[] arrstr = buffer.toString().split("");
        
        for (int i = 0; i < arrstr.length; i++) {
			if ("7".equals(arrstr[i])) {
				answer++;
			}
		}
        return answer;
    }
}
