package ch04.ex01;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		
		int result = 0;
		
		int[] dot1 = {2, 4};
		int[] dot2 = {-7, 9};
		
		
		result = sol.solution(dot1);
		System.out.println("1=="+result);
		
		result = sol.solution(dot2);
		System.out.println("2=="+result);
		
	}

}
