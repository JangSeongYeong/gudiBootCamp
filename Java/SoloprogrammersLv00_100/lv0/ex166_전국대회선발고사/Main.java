package lv0.ex166_전국대회선발고사;

public class Main {

	public static void main(String[] args) {

		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {3, 7, 2, 5, 4, 6, 1}, new boolean[] {false, true, true, true, true, false, false});
		System.out.println("20403 == "+ result);
		
		
		result = sol.solution(new int[] {1, 2, 3}, new boolean[] {true, true, true});
		System.out.println("102 == "+ result);
		
		result = sol.solution(new int[] {6, 1, 5, 2, 3, 4}, new boolean[] {true, false, true, false, false, true});
		System.out.println("50200 == "+ result);
	}

}
