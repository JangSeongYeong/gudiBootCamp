package lv0.ex171_배열만들기2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(5, 555);
		System.out.println("[5, 50, 55, 500, 505, 550, 555] == "+ Arrays.toString(result));
		
		result = sol.solution(10, 20);
		System.out.println("[-1] == "+ Arrays.toString(result));	
	}

}
