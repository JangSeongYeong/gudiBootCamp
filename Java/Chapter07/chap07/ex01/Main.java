package chap07.ex01;

public class Main {

	public static void main(String[] args) {

		// 추상 클래스는 자식 외에는 절대 부를 수 없다.
		
		// Mammal mal = new Mammal("");
	
		Person person = new Person("영희");
		person.useTool();
		person.social();
		person.talk();
		
		// 부모메서드
		person.birth();
		person.eat();
		
	}

}
