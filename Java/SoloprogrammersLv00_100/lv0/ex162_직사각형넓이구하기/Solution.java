package lv0.ex162_직사각형넓이구하기;

import java.util.Arrays;

public class Solution {
	/* 2차원 좌표 평면에 변이 축과 평행한 직사각형이 있습니다. 
	 * 직사각형 네 꼭짓점의 좌표 [[x1, y1], [x2, y2], [x3, y3], [x4, y4]]가 담겨있는 배열 dots가 매개변수로 주어질 때, 
	 * 직사각형의 넓이를 return 하도록 solution 함수를 완성해보세요. */
    public int solution(int[][] dots) {
    	// x, y 모아주기
    	int[] x = new int[] {dots[0][0],dots[1][0],dots[2][0],dots[3][0]};
    	int[] y = new int[] {dots[0][1],dots[1][1],dots[2][1],dots[3][1]};
    	
    	// 정렬시 0번 3번으로 비교 가능
    	Arrays.sort(x);
    	Arrays.sort(y);
    	
    	System.out.println(Arrays.toString(x)+Arrays.toString(y));

    	int squareX = x[0] > 0 ? x[3]-x[0] : x[3] > 0 ? Math.abs(x[0])+Math.abs(x[3]) : Math.abs(x[0])-Math.abs(x[3]);
    	int squareY = y[0] > 0 ? y[3]-y[0] : y[3] > 0 ? Math.abs(y[0])+Math.abs(y[3]) : Math.abs(y[0])-Math.abs(y[3]);
    	
        return squareX*squareY;
    }
}