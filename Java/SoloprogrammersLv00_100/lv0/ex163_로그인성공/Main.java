package lv0.ex163_로그인성공;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		String result;
		
		result = sol.solution(new String[] {"meosseugi", "1234"},
					new String[][] {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}});
		System.out.println("login == "+ result);
		
	}

}
