package lv0.ex10;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int result = 0;
		
		result = sol.solution(-4, 7, true);
		System.out.println("3 == "+result);

		result = sol.solution(-4, 7, false);
		System.out.println("-11 == "+result);
		
	}

}
