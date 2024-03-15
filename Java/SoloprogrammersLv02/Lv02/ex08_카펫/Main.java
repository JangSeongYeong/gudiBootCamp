package Lv02.ex08_카펫;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(10, 2);
		System.out.println("[4,3] == "+Arrays.toString(result));
		
		result = sol.solution(8, 1);
		System.out.println("[3,3] == "+Arrays.toString(result));
		
		result = sol.solution(24, 24);
		System.out.println("[8,6] == "+Arrays.toString(result));
		
	}

}
