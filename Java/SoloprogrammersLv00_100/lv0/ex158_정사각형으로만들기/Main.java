package lv0.ex158_정사각형으로만들기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] result;
		
		result = sol.solution(new int[][] {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}});
		System.out.println("[[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]] == "+Arrays.toString(result));
	
		result = sol.solution(new int[][] {{1,2},{3,4}});
		System.out.println("[[1, 2], [3, 4]] == "+Arrays.toString(result));
	
		result = sol.solution(new int[][] {{57,192,534,2},{9,345,192,999}});
		System.out.println("[[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]] == "+Arrays.toString(result));
	
	}

}
