package lv01.ex33_같은숫자는싫어;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int [] {1,1,3,3,0,1,1});
		System.out.println("[1,3,0,1] == "+Arrays.toString(result));
		
		result = sol.solution(new int[] {4,4,4,3,3});
		System.out.println("[4, 3] == "+Arrays.toString(result));
		
	}

}
