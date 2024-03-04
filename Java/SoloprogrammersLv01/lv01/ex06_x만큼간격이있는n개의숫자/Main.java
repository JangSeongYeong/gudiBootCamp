package lv01.ex06_x만큼간격이있는n개의숫자;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		long[] reuslt;
		
		reuslt = sol.solution(2, 5);
		System.out.println("[2,4,6,8,10] == "+Arrays.toString(reuslt));
	
		reuslt = sol.solution(4, 3);
		System.out.println("[4,8,12] == "+Arrays.toString(reuslt));
	
		reuslt = sol.solution(-4, 2);
		System.out.println("[-4, -8] == "+Arrays.toString(reuslt));
	
	}

}
