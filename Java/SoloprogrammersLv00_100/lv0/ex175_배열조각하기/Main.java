package lv0.ex175_배열조각하기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {0, 1, 2, 3, 4, 5}, new int[] {4, 1, 2});
		System.out.println("[1,2,3] == "+ Arrays.toString(result));
		
		result = sol.solution(new int[] {4, 5, 4}, new int[] {1, 0});
		System.out.println("[4, 5] == "+ Arrays.toString(result));
		
		result = sol.solution(new int[] {1, 3, 5, 7, 9, 11}, new int[] {5, 0, 4, 1, 2});
		System.out.println("[3, 5, 7] == "+ Arrays.toString(result));
		
	}

}
