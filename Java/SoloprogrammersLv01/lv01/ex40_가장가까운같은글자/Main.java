package lv01.ex40_가장가까운같은글자;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution("banana");
		System.out.println("[-1,-1,-1,2,2,2] == "+Arrays.toString(result));
		
		result = sol.solution("foobar");
		System.out.println("[-1,-1,1,-1,-1,-1] == "+Arrays.toString(result));
		
	}

}
