package chap07.ex03;

public interface MouseEvent {
	
	// interface 는 추상메서드가 기본 메서드 
	public void click(int button); // abstract 를 붙이지 않아도 된다.
	
	public void dblclick(int button);
	
	public Double[] move();
	
	// JDK 1.8부터 가능해지는것
	// default 메서드
	public default void wheel(int i) {
		if(i == 1) {
			System.out.println("윗 방향으로 스크롤");
		} else {
			System.out.println("아랫 방향으로 스크롤");
		}
	}
	
	
	// static 메서드
	public static void setDpi(int dpi) {
		System.out.println("감도 조절 : " + dpi);
	}
}
