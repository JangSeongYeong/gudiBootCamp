package ch09.ex04;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		boolean result;
		
		result = sol.solution("()()");
		System.out.println("true == "+result);
		
		result = sol.solution("(())()");
		System.out.println("true == "+result);
		
		result = sol.solution(")()(");
		System.out.println("false == "+result);
		
		result = sol.solution("(()(");
		System.out.println("false == "+result);
		
	}

}
