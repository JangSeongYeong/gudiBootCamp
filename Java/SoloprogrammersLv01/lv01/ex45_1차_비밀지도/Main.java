package lv01.ex45_1차_비밀지도;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] result;
		
		result = sol.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
		System.out.println("[\"#####\",\"# # #\", \"### #\", \"# ##\", \"#####\"] == "+Arrays.toString(result));
		
		result = sol.solution(6, new int[] {46, 33, 33 ,22, 31, 50}, new int[] {27 ,56, 19, 14, 14, 10});
		System.out.println("[\"######\", \"### #\", \"## ##\", \" #### \", \" #####\", \"### # \"] == "+Arrays.toString(result));
		
	}

}
