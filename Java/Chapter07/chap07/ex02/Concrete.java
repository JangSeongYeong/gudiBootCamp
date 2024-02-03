package chap07.ex02;

public class Concrete extends Abs {
	
	// 추상 클래스를 상속 받으면, 추상 메서드를 강제로 오버라이딩 한다.
	@Override
	public void must1() {
		
		
	}

	@Override
	public void must2() {
		
		
	}
	
	public void child() {
		System.out.println("당연히 본인만의 메서드를 만들 수도 있다.");
	}

}
