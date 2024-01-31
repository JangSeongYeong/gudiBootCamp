package chap06.ex10;

public class Racer {
	// 다형성을 매개변수에 활용했다.
	// 부모인 Car 를 상속받은 그 어떤 객체이던지 들어 올 수 있다.
	public String drive(Car car) {
		return car.run();
	}
	
	
	// 다만 들어오는 객체의 고유 메서드가 있다면 위의 형태로는 사용할 수 없다.
}
