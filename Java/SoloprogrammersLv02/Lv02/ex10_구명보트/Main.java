package Lv02.ex10_구명보트;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {70,50,80,50}, 100);
		System.out.println("3 == "+result);
		
		result = sol.solution(new int[] {70,80,50}, 100);
		System.out.println("3 == "+result);
		
	}

}
