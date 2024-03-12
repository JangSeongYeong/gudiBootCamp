package lv0.ex169_유한소수판별하기_미완;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int result;
		
		result = sol.solution(7, 20);
		System.out.println("1 == "+ result);
		
		result = sol.solution(11, 22);
		System.out.println("1 == "+ result);
		
		result = sol.solution(12, 21);
		System.out.println("2 == "+ result);
	}

}
