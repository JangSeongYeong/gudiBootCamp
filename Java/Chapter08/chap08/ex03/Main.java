package chap08.ex03;

public class Main {

	public static void main(String[] args) {
		
		// 문자열 누적합
		String str = "문자열을";
		str += "추가하면";
		str += "객체가 증가한다.";
		System.out.println(str);
		
		// StringBuffer(다수 유저를 허용하지 않음) & StringBuilder(다수 유저 허용)
		// 이름만 다를뿐 사용방법은 하나도 다르지 않고 똑같다.
		StringBuffer buffer = new StringBuffer("문자열을");
		buffer.append("추가하면");
		buffer.append("객체 크기가 증가한다.");
		System.out.println(buffer);
		
		str = buffer.toString(); // 문자열화 시킬 수 있다.
		str = buffer.reverse().toString(); // 문자열을 뒤집는다.
		
	}

}
