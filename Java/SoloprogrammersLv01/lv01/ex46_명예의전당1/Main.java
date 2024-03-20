package lv01.ex46_명예의전당1;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(3, new int[] {10, 100, 20, 150, 1, 100, 200});
		System.out.println("[10, 10, 10, 20, 20, 100, 100] == "+Arrays.toString(result));
		
		result = sol.solution(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000});
		System.out.println("[0, 0, 0, 0, 20, 40, 70, 70, 150, 300] == "+Arrays.toString(result));
		
	}

}
