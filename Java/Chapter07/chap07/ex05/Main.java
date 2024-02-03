package chap07.ex05;

import chap07.ex03.MouseEvent;
import chap07.ex03.Window;

public class Main {

	public static void main(String[] args) {
		
		// 일반적인 객체화의 경우(다형성 활용)
		MouseEvent mouse = new Window();
		// 일반적으로 인터페이스를 활용하기 위해서는 구현해줄 클래스가 필요하다.
		
		// 익명객체 활용 -> 클래스 이름이 없다.
		// 인터페이스를 구현받을 클래스의 이름이 '익명'이다.
		// 그러므로 인터페이스를 구현받은 클래스는 이곳 외에 어디에도 절대 부를 수 없다.
		// 현재 파일에서만 사용하고 안쓸경우에 사용 -> 클래스 만들기 싫을 때 사용
		MouseEvent evt = new MouseEvent() {
			@Override
			public Double[] move() {
				return null;
			}
			
			@Override
			public void dblclick(int button) {
				System.out.println(button+"번 버튼 더블 클릭");
			}
			
			@Override
			public void click(int button) {
				System.out.println(button+" 번 버튼 클릭");
			}
		};
	
		evt.click(1);
		evt.dblclick(2);
	}

}
