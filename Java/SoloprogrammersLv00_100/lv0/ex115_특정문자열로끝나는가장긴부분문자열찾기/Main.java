package lv0.ex115_특정문자열로끝나는가장긴부분문자열찾기;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		
		String result;
		
		result = sol.solution("AbCdEFG", "dE");
		System.out.println("AbCdE == "+result);
		
	}

}
