package ch09.ex03;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int result = 0;
		
		result = sol.solution(new int[]{1,4,2}, new int[]{5,4,4});
		System.out.println("29 == "+result);
		
		result = sol.solution(new int[]{1,2}, new int[]{3,4});
		System.out.println("10 == "+result);
	}

}
