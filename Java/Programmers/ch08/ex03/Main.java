package ch08.ex03;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		Solution2 sol2 = new Solution2();
		
		String result = sol.solution(23);
		System.out.println("cd == "+result);
		
		result = sol2.solution(23);
		System.out.println("cd == "+result);
		
		
		result = sol.solution(51);
		System.out.println("fb == "+result);
		
		result = sol.solution(100);
		System.out.println("baa == "+result);
	
	}

}
