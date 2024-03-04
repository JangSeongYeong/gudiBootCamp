package lv01.ex20_없는숫자더하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {1,2,3,4,6,7,8,0});
		System.out.println("14 == "+result);
		
		result = sol.solution(new int[] {5,8,4,0,6,7,9});
		System.out.println("6 == "+result);
	}

}
