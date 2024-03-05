package lv01.ex23_내적;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2});
		System.out.println("3 == "+result);
		
		result = sol.solution(new int[] {-1,0,1}, new int[] {1,0,-1});
		System.out.println("-2 == "+result);
		
	}

}
