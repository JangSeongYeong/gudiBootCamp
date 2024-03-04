package lv01.ex12_문자열내p와y의개수;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		boolean result;
		
		result = sol.solution("pPoooyY");
		System.out.println("true == "+result);
		
		result = sol.solution("Pyy");
		System.out.println("false == "+result);
	
	}

}
