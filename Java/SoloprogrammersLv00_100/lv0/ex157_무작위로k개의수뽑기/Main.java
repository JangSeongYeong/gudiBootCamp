package lv0.ex157_무작위로k개의수뽑기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(new int[] {0,1,1,2,2,3}, 3);
		System.out.println("[0,1,2] =="+Arrays.toString(result));
		
		result = sol.solution(new int[] {0,1,1,1,1}, 4);
		System.out.println("[0,1,-1,-1] =="+Arrays.toString(result));
		
		result = sol.solution(new int[] {0,1,3,2}, 4);
		System.out.println("[0,1,3,2] =="+Arrays.toString(result));
		
		result = sol.solution(new int[] {0,1,3,2}, 3);
		System.out.println("[0,1,3] =="+Arrays.toString(result));
	}

}
