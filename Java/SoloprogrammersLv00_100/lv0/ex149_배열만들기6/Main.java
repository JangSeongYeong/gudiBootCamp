package lv0.ex149_배열만들기6;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {0, 1, 1, 1, 0});
		System.out.println("[0, 1, 0] == "+Arrays.toString(result));
		
	}

}
