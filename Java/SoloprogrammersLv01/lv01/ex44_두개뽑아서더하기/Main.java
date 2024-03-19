package lv01.ex44_두개뽑아서더하기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {2,1,3,4,1});
		System.out.println("[2,3,4,5,6,7] == "+Arrays.toString(result));
		
		result = sol.solution(new int[] {5,0,2,7});
		System.out.println("[2,5,7,9,12] == "+Arrays.toString(result));
		
	}

}
