package chap06.ex01;

public class Main {

	public static void main(String[] args) {
		
		// Mamal 의 기능을 사용해 보자 - birth(), eat()
		Mamal mamal = new Mamal();
		mamal.birth();
		mamal.eat();
		
		// Person - useTool(), social(), talk()
		Person person = new Person();
		person.useTool();
		person.social();
		person.talk();
		person.birth();
		person.eat();
		
		// 상속에서 내것처럼 쓴다 == 나를 객체화 화면 부모것도 쓸 수 있다. -> 부모를 객체화할 필요없이
		
	}

}
