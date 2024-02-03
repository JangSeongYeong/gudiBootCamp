package chap07.ex03;

public class Linux implements MouseEvent {

	@Override
	public void click(int button) {
		System.out.println(button+" 번 버튼 클릭");
	}

	@Override
	public void dblclick(int button) {
		System.out.println(button+" 번 버튼 더블 클릭");
	}

	@Override
	public Double[] move() {
		System.out.println("원래는 움직임 좌표인데 그냥 놔두기");
		return null;
	}

}
