package ch04.ex02;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SolutionTwo sol = new SolutionTwo();
		
		int[] result = {};
		int[] num_list;
		
		num_list = new int [] {1,2,3,4,5};
		result = sol.solution(num_list);
		System.out.println("[2,3]=="+Arrays.toString(result));

		num_list = new int [] {1,3,5,7};
		result = sol.solution(num_list);
		System.out.println("[0,4]=="+Arrays.toString(result));

		
	}

}
