package lv01.ex37_삼총사;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {-2, 3, 0, 2, -5});
		System.out.println("2 == "+result);
		
		result = sol.solution(new int[] {-3, -2, -1, 0, 1, 2, 3});
		System.out.println("5 == "+result);
		
		result = sol.solution(new int[] {-1, 1, -1, 1});
		System.out.println("0 == "+result);
		
		
	}

}
