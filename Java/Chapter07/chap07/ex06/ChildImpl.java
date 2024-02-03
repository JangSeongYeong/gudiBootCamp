package chap07.ex06;

// Child, KeyEvent, MouseEvent 의 추상메서드를 모두 강제 오버라이드 한다.
public class ChildImpl implements Child {
	// keyEvent 내용
	@Override
	public void keyDown(int key) {
		System.err.println((char)key+" 키 누름");
	}

	@Override
	public void keyUp(int key) {
		System.err.println((char)key+" 키 뗌");
	}
	
	// MouseEvent 내용
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
		return null;
	}

	//Child 의 내용
	@Override
	public void textField(String input) {
		System.out.println(input+" 라고 입력");
	}

	@Override
	public void selectOne() {
		System.out.println("아이템 선택");
	}

	@Override
	public void checkOne() {
		System.out.println("아이템 체크");
	}

}
