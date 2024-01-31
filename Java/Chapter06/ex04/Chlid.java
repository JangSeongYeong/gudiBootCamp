package chap06.ex04;


// 상속 받은 클래스 (1개의 자바 파일에 1개 이상의 클래스가 가능)
public class Chlid extends ParentHouse {

	@Override
	public void useRoom() {
		System.out.println("첫째가 방을 사용한다.");
	}
	
}

// 자바 파일에는 해당 자파파일과 이름이 동일한 클래스 하나만 public 을 가져갈 수 있다.
class ChlidOne extends ParentHouse {

	@Override
	public void useRoom() {
		System.out.println("둘째가 방을 사용한다.");
	}
	
}

class ChlidTwo extends ParentHouse {
	
	@Override
	public void useRoom() {
		System.out.println("셋째가 방을 사용한다.");
	}
	
}

class ChlidThree extends ParentHouse {
	
	@Override
	public void useRoom() {
		System.out.println("넷째가 방을 사용한다.");
	}
	
}

class ChlidFour extends ParentHouse {
	
	@Override
	public void useRoom() {
		System.out.println("다섯째가 방을 사용한다.");
	}
	
}
