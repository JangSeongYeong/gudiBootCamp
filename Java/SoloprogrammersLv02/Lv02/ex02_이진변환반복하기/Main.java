package Lv02.ex02_이진변환반복하기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution("110010101001");
		System.out.println("[3,8] == "+Arrays.toString(result));
		
		result = sol.solution("01110");
		System.out.println("[3,3] == "+Arrays.toString(result));
		
		result = sol.solution("1111111");
		System.out.println("[4,1] == "+Arrays.toString(result));
		
	}

}
