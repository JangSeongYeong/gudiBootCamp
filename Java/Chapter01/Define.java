
public class Define {

	public static void main(String[] args) { // 얘가 없으면 프로그램이 스스로 실행되지 않는다.
		/* 여러줄 주석
		 * 여러 줄을 사용 할때 쓴다. 
		 */
		
		boolean varBool = true;	// 빨강 -> 에러, 노랑 -> 비효율적이다.
		String varStr = "문자열"; 	// 여러 글자(더블쿼터)
		char varChar = 'A';			// 한 글자(싱글쿼터)
		
		int varInt = 0;					// 일반적인 정수
		long varLong = 1000000000;		// 큰 정수 (강사님이 사용하는 long은 연봉정도를 생각 "천만에서 억")
		
		double varDouble = 0.00001; 	// 큰 소숫점(일반적으로 소숫점 5자리 이상, GPS에서 좌표값을 사용할때 5자리임)
		float varFloat = 0.1f;	// 일반적인 소숫점 (자바는 소수점을 기본 double로 생각해 float으로 사용하려면 뒤에 f를 붙여둔다.)
		
		
	}

}
