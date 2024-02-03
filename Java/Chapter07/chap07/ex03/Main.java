package chap07.ex03;

public class Main {

	public static void main(String[] args) {
		
		// 1. 인터페이스도 다형성을 활용할 수 있다.
		// 클래스 다형성(상속받은 클래스가 부모 클래스 형태로 들어가는 것)
		// 인터페이스 다형성(구현받은 클래스가 인터페이스 형태로 들어가는것)
		
		MouseEvent mouse;
		
		mouse = new Window();
		mouse.click(1);
		
		mouse = new Linux();
		mouse.dblclick(2);
		
		mouse = new Mac();
		mouse.dblclick(3);
		
		// 2. 인터페이스는 객체화할 수 없다. -> 자립 불가능
		// 인터페이스를 활용해주는 클래스가 있어야 한다.(인터페이스는 규격의 개념이기 때문)
		// MouseEvent m = new MouseEvent(); // 불가능
		
		mouse.wheel(1);
		MouseEvent.setDpi(800);
	}

}
