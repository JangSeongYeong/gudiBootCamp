package chap07.ex03;

// 인터페이스는 상속(extends) 이 아닌 구현(implements) 이라고 부른다.
public class Window implements MouseEvent {
	
	@Override
	public void click(int button) {
		System.out.println(button+" 번 버튼 클릭");
	}

	@Override
	public void dblclick(int button) {
		System.out.println(button+"번 버튼 더블 클릭");
	}

	@Override
	public Double[] move() {
		System.out.println("원래는 움직임 좌표 반환인데 그냥 놔두자");
		return null;
	}

}
