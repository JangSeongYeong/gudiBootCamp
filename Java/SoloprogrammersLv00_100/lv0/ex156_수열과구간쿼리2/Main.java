package lv0.ex156_수열과구간쿼리2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {0,1,2,4,3}, new int[][] {{0,4,2}, {0,3,2}, {0,2,2}});
		System.out.println("[3,4,-1] == "+Arrays.toString(result));
		
		result = sol.solution(new int[] {5,4,3,2,1}, new int[][] {{0,4,3}});
		System.out.println("[4] == "+Arrays.toString(result));
		
	}

}
