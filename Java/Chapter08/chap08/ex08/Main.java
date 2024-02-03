package chap08.ex08;

public class Main {
	
	// main 에서 throws 는 JVM 에게 전가 -> 안한것과 다름이 없다.
	public static void main(String[] args) {
		
		
		
		try {
			// 또는 내가 처리
			Sub sub = new Sub();
			sub.method1(); // 1. main() -> method1() 호출			
		} catch (Exception e) { // 예외에 대한 모든 정보가 e 에 있다.
			System.out.println("숫자만 입력해야지");
			// 예외 발생에 대한 간단한 메시지
			System.out.println(e.toString());
		}
		
	}

}
