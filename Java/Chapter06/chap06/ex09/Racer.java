package chap06.ex09;

public class Racer {
	
	// 이 메서드는 벤츠만 운행 가능하다.
	public void drive(Benz benz) {
		System.out.println(benz.run());
	}
	
	// BMW
	public void drive(Bmw bmw) {
		System.out.println(bmw.run());
	}

	// Audi
	public void drive(Audi audi) {
		System.out.println(audi.run());;
	}
	
	/* 매개변수의 객체가 달라지면 객체에 맞게 메서드를 계속 만들어 줘야 한다.
	 * 오버로드가 지원되므로 메서드 이름을 추가로 만들거나 사용자가 이름을 하나하나 기억해야 하는 일은 없다.
	 * 다만, 차량 객체가 추가될수록 거기에 대응하는 메서드는 계속 추가해줘야 한다.
	 */
	
	
}
