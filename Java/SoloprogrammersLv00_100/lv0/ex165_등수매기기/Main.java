package lv0.ex165_등수매기기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[][] {{80, 70}, {90, 50}, {40, 70}, {50, 80}});
		System.out.println("[1, 2, 4, 3] == "+ Arrays.toString(result));
		
		
		result = sol.solution(new int[][] {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}});
		System.out.println("[4, 4, 6, 2, 2, 1, 7] == "+ Arrays.toString(result));
		
		result = sol.solution(new int[][] {{1,2},{1,1}});
		System.out.println("[1, 2] == "+ Arrays.toString(result));
		
	}

}
