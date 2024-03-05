package lv01.ex21_나누어떨어지는숫자배열;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {5, 9, 7, 10}, 5);
		System.out.println("[5,10] == "+Arrays.toString(result));
		
		result = sol.solution(new int[] {2, 36, 1, 3}, 1);
		System.out.println("[1,2,3,36] == "+Arrays.toString(result));
		
		result = sol.solution(new int[] {3,2,6}, 10);
		System.out.println("[-1] == "+Arrays.toString(result));
	}

}
