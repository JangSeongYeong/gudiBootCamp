package lv0.ex127_진료순서정하기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] result;

		result = sol.solution(new int[] {3, 76, 24});
		System.out.println("[3, 1, 2] == "+Arrays.toString(result));
	}

}
