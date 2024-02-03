package chap06.ex02;

public class Main {

	public static void main(String[] args) {
		
		// 사용하고 싶은 메서드가 각 클래스에 흩어져 있으므로 각각 객체화 해서 불러내야 한다.
		int result = 0;
		Operator op1 = new Operator();
		result = op1.plus(10, 5);
		System.out.println(result);
		
		Operator2 op2= new Operator2();
		result = op2.minus(10, 5);
		System.out.println(result);
		
		Operator3 op3= new Operator3();
		result = op3.multi(10, 5);
		System.out.println(result);
		
		Operator4 op4= new Operator4();
		result = op4.devide(10, 5);
		System.out.println(result);
		
		
		// 4칙 연산을 해주자고 객체 4개를 선언하는 것도 귀찮고, 각 클래스에 어떤 메서드가 있는지 확인하기도 힘들다.
		// 그래서 하나의 클래스에 몰아넣어 버리자
		
		// 상속화 후 -> 사용자 입장에서는 Operator 클래스만 기억하면 된다.
		result = op1.minus(10, 5);
		result = op1.multi(10, 5);
		result = op1.devide(10, 5);
		
	}

}
