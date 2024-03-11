package lv01.ex38_최소직사각형;

import java.util.Arrays;

public class Solution {
	/* 가장 긴 가로 길이와 세로 길이가 각각 80, 70이기 때문에 
	 * 80(가로) x 70(세로) 크기의 지갑을 만들면 모든 명함들을 수납할 수 있습니다. 
	 * 하지만 2번 명함을 가로로 눕혀 수납한다면 
	 * 80(가로) x 50(세로) 크기의 지갑으로 모든 명함들을 수납할 수 있습니다. 
	 * 이때의 지갑 크기는 4000(=80 x 50)입니다.
	 * 
	 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다. 
	 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록*/
    public int solution(int[][] sizes) {
    	// 명함을 작은 수가 앞으로 오게 정렬
    	// max 각각 행의 max 값 찾기
    	int wmax = 0;
    	int hmax = 0;
    	for (int[] is : sizes) {
    		Arrays.sort(is);
    		wmax = (int)Math.max(is[0], wmax);
    		hmax = (int)Math.max(is[1], hmax);
		}
    	
    	return wmax * hmax;
    }
}