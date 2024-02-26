package lv0.ex133_2의영역;

public class Solution {
	/*정수 배열 arr가 주어집니다. 
	 * 배열 안의 2가 모두 포함된 가장 작은 연속된 부분 배열을 return 하는 solution 함수를 완성해 주세요
	 * 단, arr에 2가 없는 경우 [-1]을 return 합니다.*/
	public int[] solution(int[] arr) {
        int[] answer = {};
        
        // 2인지 아닌지 확인
        int first2 = -1;
        int last2 = -1;
        
        // 2의 시작 지점 끝지점 구하기
        for (int i = 0; i < arr.length; i++) {
			// 시작 지점
        	if (arr[i] == 2) {
        		if (first2 == -1 || i == 0) {
					first2 = i;
				}else {
					last2 = i;
				}
        	} 
		}

        if(first2 == -1) {
        	return new int[] {-1};
		} else if(last2 == -1) {
        	return new int[] {2};
		}
        
        answer = new int[last2-first2+1];
        int count = 0;
        for (int i = first2; i <= last2; i++) {
			answer[count] = arr[i];
			count++;
		}
        
        return answer;
    }
}
