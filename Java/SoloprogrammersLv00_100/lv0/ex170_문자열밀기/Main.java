package lv0.ex170_문자열밀기;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int result;
		
		result = sol.solution("hello", "ohell");
		System.out.println("1 == "+ result);
		
		result = sol.solution("apple", "elppa");
		System.out.println("-1 == "+ result);
		
		result = sol.solution("atat", "tata");
		System.out.println("1 == "+ result);
		
		result = sol.solution("abc", "abc");
		System.out.println("0 == "+ result);
		
	}

}
