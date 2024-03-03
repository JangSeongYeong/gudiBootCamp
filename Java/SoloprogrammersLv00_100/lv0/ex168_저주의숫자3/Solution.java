package lv0.ex168_저주의숫자3;

public class Solution {
	/* 3의 배수가 나오면 그 다음수로 넘어가기 */
	public int solution(int n) {
        int answer = 1;
        int cnt = 1;
        StringBuffer buffer = new StringBuffer();
        while (cnt != n+1) {
        	buffer.append(String.valueOf(answer));
			if(answer%3 == 0 || buffer.toString().contains("3")) {
				answer++;
				buffer.delete(0, buffer.length());
			} else {
				if (cnt != n) {
					answer++;
				}
				cnt++;
				buffer.delete(0, buffer.length());
			}
		}
        return answer;
    }
}