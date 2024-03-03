package lv0.ex161_캐릭터의좌표;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new String[] {"left", "right", "up", "right", "right"}, new int[] {11,11});
		System.out.println("[2, 1] == "+ Arrays.toString(result));
		
	}

}
