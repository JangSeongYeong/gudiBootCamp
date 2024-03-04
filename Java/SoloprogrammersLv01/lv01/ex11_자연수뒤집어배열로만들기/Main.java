package lv01.ex11_자연수뒤집어배열로만들기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(12345);
		System.out.println("[5,4,3,2,1] == "+Arrays.toString(result));
		
		result = sol.solution(1);
		System.out.println("[1] == "+Arrays.toString(result));
	
	}

}
