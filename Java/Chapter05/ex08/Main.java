package chap05.ex08;

public class Main {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		long val1 = 7;
		double val2 = 8.8;
		
		System.out.println(cal.plusld(val1, val2));
		
		OverCalc calc =new OverCalc();
		
		
		System.out.println(calc.plus("A", 1));
		
		// 오버로드는 하나의 이름으로 여러 매개변수를 줄 수 있다.
		// 그리고 사용자 입장에서는 매개변수를 넣으면 해당 메서드로 자동 연결 된다.
		// 만약 오버로드가 없었다면 해당 매개변수를 사용하는 메서드를 찾아야 한다.
		
		
	}

}
