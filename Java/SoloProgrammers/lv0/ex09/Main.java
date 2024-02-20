package lv0.ex09;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result = 0;
		
		result = sol.solution("aAb1B2cC34oOp");
		System.out.println("10 == "+result);
		
		result = sol.solution("1a2b3c4d123");
		System.out.println("16 == "+result);
		
	}

}
