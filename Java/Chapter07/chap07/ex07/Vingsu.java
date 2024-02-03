package chap07.ex07;

public interface Vingsu {
	public default void iceFlake() {
		System.out.println("얼음 가루를 넣는다.");
	}
	
	public default void milk() {
		System.out.println("우유를 넣는다.");
	}
	
	public default void readBean() {
		System.out.println("팥을 넣는다.");
	}
	
	public default void jelly() {
		System.out.println("젤리를 넣는다.");
	}
	
	public void etc();
	
}
