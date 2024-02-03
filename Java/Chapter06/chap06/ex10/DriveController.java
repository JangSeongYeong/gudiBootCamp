package chap06.ex10;

public class DriveController {

	public static void main(String[] args) {

		// 차량 준비 (필드 다형성)
		Car car;
		
		// 레이서 준비
		Racer racer = new Racer();
		
		// 운전
		car = new Audi(); // 여기서 car 는 필드 다형성
		System.out.println(racer.drive(car)); // 여기서 car 는 매개변수 다형성
		
		car = new Benz();
		System.out.println(racer.drive(car));
		
		car = new Bmw();
		System.out.println(racer.drive(car));
		
	}

}
