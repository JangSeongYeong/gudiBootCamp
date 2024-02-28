package lv0.ex150_왼쪽오른쪽;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		String[] result;
		
		result = sol.solution(new String[] {"r", "u", "d", "d"});
		System.out.println("[\"u\", \"d\", \"d\"] == "+Arrays.toString(result));
		
	}

}
