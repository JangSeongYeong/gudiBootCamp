package lv01.ex38_최소직사각형;

public class Main {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int result;
		
		result = sol.solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}});
		System.out.println("4000 == "+result);
		
		result = sol.solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5,15}});
		System.out.println("120 == "+result);
		
		result = sol.solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}});
		System.out.println("133 == "+result);
		
	}

}
