package ex04.group;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		Pattern p = null;
		
		System.out.println("(x) : x 를 그룹으로 처리 함");
		p = Pattern.compile("(6CD)");
		print("(6CD)", p.matcher("ab6CDE443fgh22iJKlmn1o"),1);
		System.out.println();
		
		System.out.println("(x)(y) : x 와 y를 다른 그룹으로 처리 함");
		p = Pattern.compile("(6CD)|(443f)"); // 6CD 와 443f 를 둘 다 찾겠다.
		print("(6CD)|(443f)", p.matcher("ab6CDE443fgh22iJKlmn1o"),1);
		// 어느 그룹에서 찾아낸건지 알고 싶을 경우...
		print("(6CD)|(443f)", p.matcher("ab6CDE443fgh22iJKlmn1o"),2);
		System.out.println();
		
		// 공백문자는 시작시 공백이 없어도 첫 문자면 가져와 준다. (단어의 시작과 끝을 찾아내는데 유용)
		// 첫 시작 문자 두글자를 동시에 가져올 경우
		p = Pattern.compile("\\b([\\w])([\\w])");
		print("\\b([\\w])([\\w])", p.matcher("my team has groups"),2);
		System.out.println();
		
		System.out.println("x(?!y) : x 다음에 y가 오지 않는다.");
		// 숫자 다음에 문자가 오지 않도록
		p = Pattern.compile("[\\d](?![^\\d])"); // []로 묶어주는거 중요
		// ?! : 뒤에 있는 패턴을 포함하지 않아야 한다. (부방향 전방 탐색)
		System.out.println("1234 : "+p.matcher("1234").find()); // 1234
		System.out.println("1f : "+p.matcher("1f").find()); // 1f
		System.out.println("1F : "+p.matcher("1F").find()); // 1F
		System.out.println();
		
		
		
	}

	public static void print(String msg, Matcher m, int cnt) {
		System.out.print(msg+" : ");
		
		while (m.find()) {
			if (cnt > 1) {
				System.out.print(m.group(1)+", "+m.group(2)+" /");
			} else {
				System.out.print(m.group()+" ");
			}
		}
		System.out.println();
	}
}
