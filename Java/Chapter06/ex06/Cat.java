package chap06.ex06;

public class Cat extends Mammal {

	@Override
	public void birth() {
		System.out.println("새끼를 6마리 낳는다.");
	}
	
	public void mew() {
		System.out.println("야옹 하고 운다.");
	}
}
