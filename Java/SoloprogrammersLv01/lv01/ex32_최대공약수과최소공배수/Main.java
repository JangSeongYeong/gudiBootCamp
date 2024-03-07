package lv01.ex32_최대공약수과최소공배수;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(3, 12);
		System.out.println("[3, 12] == "+Arrays.toString(result));
		
		result = sol.solution(2, 5);
		System.out.println("[1, 10] == "+Arrays.toString(result));
		
	}

}
