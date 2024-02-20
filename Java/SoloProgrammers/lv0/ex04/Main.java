package lv0.ex04;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int result = sol.solution(new String[] {"a", "b", "c"}, new String[] {"com", "b", "d", "p", "c"} );
		System.out.println("2 == "+result);
		
		result = sol.solution(new String[] {"n", "omg"}, new String[] {"m", "dot"} );
		System.out.println("0 == "+result);
		
	}

}
