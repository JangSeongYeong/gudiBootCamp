package lv01.ex10_문자열을정수로바꾸기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int reuslt;
		
		reuslt = sol.solution("1234");
		System.out.println("1234 == "+reuslt);
	
		reuslt = sol.solution("-1234");
		System.out.println("-1234 == "+reuslt);
	
	}

}
