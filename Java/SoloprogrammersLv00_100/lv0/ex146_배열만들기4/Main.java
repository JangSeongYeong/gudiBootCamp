package lv0.ex146_배열만들기4;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] result;
		
		result = sol.solution(new int[] {1, 4, 2, 5, 3});
		System.out.println("[1,2,3] == "+Arrays.toString(result));
	}

}
