package lv01.ex36_이상한문자만들기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String result;
		
		result = sol.solution("try hello world");
		System.out.println("TrY HeLlO WoRlD == "+result);
		
		result = sol.solution("  TRy HElLo  WORLD ");
		System.out.println("  TrY HeLlO  WoRlD =="+result);
		
		
	}

}
