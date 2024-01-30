
public class Scope { // class
	
	String str = "some text"; // class 안에서 사용 가능 
	
	public static void main(String[] args) { // 자바 : method, 다른 언어 : function
		
		int num = 123; // method 안에서 사용 가능
		
		for (int i = 0; i < 5; i++) { // 문장(statement)
			int sum = num + i; // statement 안에서만 사용 가능
			System.out.println(sum); //syso후 Alt Enter
		}
		//		System.out.println(sum); // sum이 문장 안에 있어서 실행 불가능
	}

}
