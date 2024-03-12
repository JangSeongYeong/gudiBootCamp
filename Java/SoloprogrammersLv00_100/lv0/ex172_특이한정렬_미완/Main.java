package lv0.ex172_특이한정렬_미완;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {1, 2, 3, 4, 5, 6}, 4);
		System.out.println("[4, 5, 3, 6, 2, 1] == "+ Arrays.toString(result));
		
		result = sol.solution(new int[] {10000,20,36,47,40,6,10,7000}, 30);
		System.out.println("[36, 40, 20, 47, 10, 6, 7000, 10000] == "+ Arrays.toString(result));	
	}

}
