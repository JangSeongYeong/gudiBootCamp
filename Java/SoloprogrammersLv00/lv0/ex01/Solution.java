package lv0.ex01;

import java.util.Arrays;

public class Solution {
	// 배열의 중앙 값 구하기
	public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        answer = array[(array.length/2)];
        return answer;
    }
}
