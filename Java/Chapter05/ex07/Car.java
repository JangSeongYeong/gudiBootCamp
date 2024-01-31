package chap05.ex07;

public class Car {

	int gear = 0; // 기어
	boolean on = false; // 시동상태
	
	public Car() { // 혹시 모르니 초기화 해준다.
		gear = 0;
		on = false;
	}
	
	public void start() {
		if(on) {
			System.out.println("이미 시동이 걸려있습니다.");
		} else {
			System.out.println("시동이 걸렸습니다.");
			on = !on;
		}
	}
	
	public void change(int gear) {
		System.out.println(gear+" 단으로 변속 되었습니다.");
		this.gear = gear;
	}

}
