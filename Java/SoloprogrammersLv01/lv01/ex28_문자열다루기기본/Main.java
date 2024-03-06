package lv01.ex28_문자열다루기기본;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		boolean result;
		
		result = sol.solution("a234");
		System.out.println("false == "+result);
		
		result = sol.solution("1234");
		System.out.println("true == "+result);
		
	}

}
