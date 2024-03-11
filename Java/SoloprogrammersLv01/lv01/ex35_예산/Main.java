package lv01.ex35_예산;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {1,3,2,5,4}, 9);
		System.out.println("3 == "+result);
		
		result = sol.solution(new int[] {2,2,3,3}, 10);
		System.out.println("4 == "+result);
		
	}

}
