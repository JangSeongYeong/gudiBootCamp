
public class ForEach {

	public static void main(String[] args) {
		
		int[] score = {10,20,30,40,50};
	
		// 일반 for
		for (int i = 0; i < score.length; i++) {
			System.out.println(i+ " : " + score[i]);
		}
		
		System.out.println();
		
		// 향상된 for
		for (int s : score) {
			System.out.println(s);
		}
		
	}

}
