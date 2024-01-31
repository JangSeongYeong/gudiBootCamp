
public class ArrDefine {

	public static void main(String[] args) {
		
		// 선언과 동시에 값을 넣는 방법
		int[] score = {70, 80, 90};  // 크기: 3, 주소: 0, 1, 2
		String names[] = {"홍길동", "고길동", "박길동"};
		
		// new 연산자로 값을 추가하는 방법   (선언 후 값 선언)
		int [] scores;	// 이것만으로는 사용 불가
		scores = new int[] {70,80,90};
		
		// new 연산자로 바로 선언하는 방법
		int[] arr = new int[6];
		
		
		
	}

}
