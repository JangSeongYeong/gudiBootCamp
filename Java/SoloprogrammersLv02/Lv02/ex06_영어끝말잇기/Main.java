package Lv02.ex06_영어끝말잇기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] result;
		
		result = sol.solution(3, new String[] {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
		System.out.println("[3, 3] == "+Arrays.toString(result));
		
		result = sol.solution(5, new String[] {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"});
		System.out.println("[0, 0] == "+Arrays.toString(result));
		
		result = sol.solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"});
		System.out.println("[1, 3] == "+Arrays.toString(result));
		
	}

}
