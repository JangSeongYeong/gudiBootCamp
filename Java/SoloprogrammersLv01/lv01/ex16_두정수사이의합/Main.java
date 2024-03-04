package lv01.ex16_두정수사이의합;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		long result;
		
		result = sol.solution(3, 5);
		System.out.println("12 == "+result);
		
		result = sol.solution(3, 3);
		System.out.println("3 == "+result);

		result = sol.solution(5, 3);
		System.out.println("12 == "+result);

	}

}
