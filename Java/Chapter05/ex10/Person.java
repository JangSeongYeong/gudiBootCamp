package chap05.ex10;

public class Person {

	final String nation;
	static final String ssn ="000609-132"; // static final 은 생성자로 초기화 할 수 없어서 처음부터 값을 부여해야 한다. -> 상수(변하지 않는 값)
	final String name;
	int age;
	
	// final 은 프로그램 시작시 초기화 후에 끝날때까지 변할 수 없다.
	// 그래서 반드시 생성자를 통해 초기화 해줘야 한다. (-> 생성자는 프로그램 시작시에 바로 시작하니까)
	public Person(String nation, String name) {
		this.name = name;
		this.nation = nation;
	}
	
}
