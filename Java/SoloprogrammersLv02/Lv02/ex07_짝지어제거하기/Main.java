package Lv02.ex07_짝지어제거하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution("baabaa");
		System.out.println("1 == "+result);
		
		result = sol.solution("cdcd");
		System.out.println("0 == "+result);
		
	}

}
