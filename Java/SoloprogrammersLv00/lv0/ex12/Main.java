package lv0.ex12;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		String result;
		
		result = sol.solution("aBcDeFg");
		System.out.println("ABCDEFG == "+result);

		result = sol.solution("AAA");
		System.out.println("AAA == "+result);
	}

}
