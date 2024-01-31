package chap06.ex04;

public class Main {

	public static void main(String[] args) {
		// 다형성을 사용하기 전(첫째 ~ 다섯째)
		// 사용할 객체가 여러개라면 여러개의 객체를 담을 변수를 선언해줘야 한다.
		// 만약 사용할 객체의 개수가 100개라면, 몇개의 변수를 선언해야 하는가?
		
		Chlid ch = new Chlid();
		ch.useRoom();
		
		ChlidOne ch1 = new ChlidOne();
		ch1.useRoom();
		
		ChlidTwo ch2 = new ChlidTwo();
		ch2.useRoom();
		
		ChlidThree ch3 = new ChlidThree();
		ch3.useRoom();
		
		ChlidFour ch4 = new ChlidFour();
		ch4.useRoom();
		
		System.out.println();
		// 다형성을 사용한 후
		// 하나의 변수(부모타입)에 여러 객체(자식타입)를 수용할 수 있다.
		ParentHouse house;
		house = new Chlid();   //-> 정석적으로 했다면 Child 라는 타입에 변수를 넣었어야 했다. -> 현재 : ParentHouse
		house.useRoom();
		
		house = new ChlidOne();
		house.useRoom();
		
		house = new ChlidTwo();
		house.useRoom();
		
		house = new ChlidThree();
		house.useRoom();
		
		house = new ChlidFour();
		house.useRoom();
		
		
		
		
		
		
	}

}
