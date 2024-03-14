package lv0.ex173_다항식더하기;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String result;
		
		result = sol.solution("3x + 7 + x");
		System.out.println("4x + 7 == "+ result);
		
		result = sol.solution("x + x + x");
		System.out.println("3x == "+ result);	
		
	}

}
