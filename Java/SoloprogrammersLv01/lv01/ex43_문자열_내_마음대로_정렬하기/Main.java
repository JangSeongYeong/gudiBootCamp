package lv01.ex43_문자열_내_마음대로_정렬하기;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] result;
		
		result = sol.solution(new String[] {"sun", "bed", "car"}, 1);
		System.out.println("[\"car\", \"bed\", \"sun\"] == "+Arrays.toString(result));
		
		result = sol.solution(new String[] {"abce", "abcd", "cdx"}, 2);
		System.out.println("[\"abcd\", \"abce\", \"cdx\"] == "+Arrays.toString(result));
		
		result = sol.solution(new String[] {"abc", "ab"}, 1);
		System.out.println("[\"ab\", \"abc\"] == "+Arrays.toString(result));
		
	}

}
