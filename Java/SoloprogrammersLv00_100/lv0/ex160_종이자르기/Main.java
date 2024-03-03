package lv0.ex160_종이자르기;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int result;
		
		result = sol.solution(2, 2);
		System.out.println("3 == "+ result);
		
		result = sol.solution(2, 5);
		System.out.println("9 == "+ result);
		
		result = sol.solution(1, 1);
		System.out.println("0 == "+ result);
	}

}
