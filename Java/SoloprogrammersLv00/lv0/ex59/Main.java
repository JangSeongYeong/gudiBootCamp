package lv0.ex59;

public class Main {

	public static void main(String[] args) {
		
		Solution sol = new Solution();
		int result = 0;
		
		result = sol.solution("ABBAA", "AABB");
		System.out.println("1 == "+result);
		
		result = sol.solution("ABAB", "ABAB");
		System.out.println("0 == "+result);
		
	}

}
