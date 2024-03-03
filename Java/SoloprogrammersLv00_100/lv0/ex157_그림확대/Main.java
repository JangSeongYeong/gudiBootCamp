package lv0.ex157_그림확대;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String[] result;
		
		result = sol.solution(new String[] {".xx...xx.", "x..x.x..x", "x...x...x", ".x.....x.", "..x...x..", "...x.x...", "....x...."}, 2);
		System.out.println("[\"..xxxx......xxxx..\", \"..xxxx......xxxx..\", \"xx....xx..xx....xx\", \"xx....xx..xx....xx\", \"xx......xx......xx\", \"xx......xx......xx\", \"..xx..........xx..\", \"..xx..........xx..\", \"....xx......xx....\", \"....xx......xx....\", \"......xx..xx......\", \"......xx..xx......\", \"........xx........\", \"........xx........\"] == "+Arrays.toString(result));
		
	}

}
