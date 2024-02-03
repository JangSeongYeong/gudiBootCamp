package chap09.ex05;

public class Towel {

	private String color;
	
	public Towel(String color) {
		this.color = color;
		// 초기화 생성자가 호출될때 값을 집어 넣는것
	}
	
	public String getColor() {
		return color;
	}
}
