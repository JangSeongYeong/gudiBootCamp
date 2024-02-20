package lv0.ex05;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		int result = sol.solution(new int[] {1, 2, 3});
		System.out.println("2 == "+result);

		result = sol.solution(new int[] {3, 6, 2});
		System.out.println("2 == "+result);
		
		result = sol.solution(new int[] {199, 72, 222});
		System.out.println("1 == "+result);
		
	}

}
