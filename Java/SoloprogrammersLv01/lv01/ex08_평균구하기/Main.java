package lv01.ex08_평균구하기;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		double reuslt;
		
		reuslt = sol.solution(new int[] {1,2,3,4});
		System.out.println("2.5 == "+reuslt);
	
		reuslt = sol.solution(new int[] {5,5});
		System.out.println("5 == "+reuslt);
	
	}

}
