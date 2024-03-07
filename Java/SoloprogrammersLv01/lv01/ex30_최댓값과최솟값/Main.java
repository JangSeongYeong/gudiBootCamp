package lv01.ex30_최댓값과최솟값;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String result;
		
		result = sol.solution("1 2 3 4");
		System.out.println("1 4 == "+result);
		
		result = sol.solution("-1 -2 -3 -4");
		System.out.println("-4 -1 == "+result);
		
		result = sol.solution("-1 -1");
		System.out.println("-1 -1 == "+result);
	}

}
