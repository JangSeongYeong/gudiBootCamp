
public class OutArr {

	public static void main(String[] args) {
		
		int[] scores = {95, 75, 66, 52, 32};
		
		// 0번방 호출
		System.out.println("0번방 : "+scores[0]);
		
		// 3번방 호출
		System.out.println("3번방 : "+scores[3]);
		
		// 4번방 호출
		System.out.println("4번방 : "+scores[4]);
		
		
		// 모든 방의 값을 출력 해 보자
		for (int i = 0; i < scores.length; i++) {
			System.out.println(i+"번방 : "+scores[i]);
		}
	}

}
