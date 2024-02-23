package lv0.ex01;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		int result = sol.solution(new int[] {1,2,7,10,11});
		System.out.println("7 == "+ result);
		
		result = sol.solution(new int[] {9,-1,0});
		System.out.println("0 == "+ result);
	}

}
