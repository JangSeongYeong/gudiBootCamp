package lv0.ex56;
// 카운트 다운
public class Solution {
	/*정수 start_num와 end_num가 주어질 때, 
	 * start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.*/
	public int[] solution(int start, int end_num) {
        // 크기에 맞는 배열 생성
		int[] answer = new int[start - end_num + 1];
        
		// 배열안에 값 넣기
        for (int i = 0; i < start - end_num + 1; i++) {
			answer[i] = start - i;
		}
        
        return answer;
    }
}
