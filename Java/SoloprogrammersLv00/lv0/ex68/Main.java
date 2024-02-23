package lv0.ex68;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] result = {};
		
		result = sol.solution(new int[]{293, 1000, 395, 678, 94}, new int[]{94, 777, 104, 1000, 1, 12});
		System.out.println("[293, 395, 678] == "+Arrays.toString(result));
	}

}
