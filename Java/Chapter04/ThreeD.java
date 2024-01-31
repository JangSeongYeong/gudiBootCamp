import java.util.Iterator;

public class ThreeD {

	public static void main(String[] args) {
		// royal 아파트는 4개층 4개호 방3개
		
		String[][][] royal = new String[4][4][3];
		
		System.out.println(royal.length+"층");
		System.out.println(royal[0].length+"호");
		System.out.println(royal[0][0].length+"개");
		
		// 2층 3호 2번 방은 "철수의 방"
		royal[2][3][2] = "철수의 방";
		// 0층 0호 0번 방은 "영희의 방"
		royal[0][0][0] = "영희의 방";
		
		for (int i = 0; i < royal.length; i++) {
			for (int j = 0; j < royal[i].length; j++) {
				for (int k = 0; k < royal[i][j].length; k++) {
//					if(royal[i][j][k] != royal[2][3][2] && royal[i][j][k] != royal[0][0][0]) {
//						royal[i][j][k] = "공실";
//					}
					
					
//					royal[i][j][k] = "공실";					
//					if(royal[i][j][k].equals(royal[2][3][2])  || royal[i][j][k].equals(royal[0][0][0])) {
//						royal[2][3][2] = "철수의 방";
//						royal[0][0][0] = "영희의 방";
//					}
					
//					if (!"철수의방".equals(royal[i][j][k]) && !"영희의 방".equals(royal[i][j][k]) ) {
//						royal[i][j][k]= "공실";
//					}
					
					if (royal[i][j][k] == null) {
						royal[i][j][k] = "공실";
					}
				}
			}
		}
		
		
		// 출력부
		for (int i = 0; i < royal.length; i++) { // 층
			for (int j = 0; j < royal[i].length; j++) {
				for (int k = 0; k < royal[i][j].length; k++) {
					System.out.println(i+"층"+j+"호"+k+"방 "+royal[i][j][k]);
				}
			}
		}

	}

}
