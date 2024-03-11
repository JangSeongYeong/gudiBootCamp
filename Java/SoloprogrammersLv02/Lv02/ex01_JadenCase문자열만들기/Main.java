package Lv02.ex01_JadenCase문자열만들기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String result;
		
		result = sol.solution("3people unFollowed me");
		System.out.println("3people Unfollowed Me == "+result);
		
		result = sol.solution("for the last week");
		System.out.println("For The Last Week == "+result);
		
	}

}
