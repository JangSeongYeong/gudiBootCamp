package chap08.ex05;

public class Main {

	public static void main(String[] args) {
		
		String data1 = "12345";
		String data2 = "1234z";
		
		try {  // 문제 발생 예상 되는 곳
			// 코드 블럭이기에 여기에서 선언하면 밖에서 사용하지 못한다.
			int val1 = Integer.parseInt(data1);
			int val2 = Integer.parseInt(data2);
			System.out.println("test"); // Exception 이 발생하면 그 이후는 처리되지 않음 (개인 의문점 test)
		} catch (NumberFormatException e) { // 예외 발생시 처리 내용
			System.out.println("숫자만 입력되어야 합니다.");
		} finally { // 무조건 실행되어야 하는 곳
			System.out.println("data1 : "+data1);
			System.out.println("data2 : "+data2);
		}
		
	}

}
