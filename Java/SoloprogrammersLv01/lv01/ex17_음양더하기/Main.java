package lv01.ex17_음양더하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[] {4,7,12}, new boolean[] {true,false,true});
		System.out.println("9 == "+result);
		
		result = sol.solution(new int[] {1,2,3}, new boolean[] {false,false,true});
		System.out.println("0 == "+result);
	}

}
