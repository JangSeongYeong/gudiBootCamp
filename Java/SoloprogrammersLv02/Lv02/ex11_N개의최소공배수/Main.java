package Lv02.ex11_N개의최소공배수;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {2,6,8,14});
		System.out.println("168 == "+result);
		
		result = sol.solution(new int[] {1,2,3});
		System.out.println("6 == "+result);
		
	}

}
