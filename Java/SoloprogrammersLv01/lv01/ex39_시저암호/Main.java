package lv01.ex39_시저암호;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String result;
		
		result = sol.solution("AB", 1);
		System.out.println("BC == "+result);
		
		result = sol.solution("z", 1);
		System.out.println("a == "+result);
		
		result = sol.solution("a B z", 4);
		System.out.println("e F d == "+result);
		
	}

}
