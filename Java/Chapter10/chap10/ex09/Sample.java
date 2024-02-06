package chap10.ex09;

import java.io.Serializable;

// 클래스(Object)를 전송하기 위해서는 직렬화(잘게 쪼개 일렬로 보내는 것)가 필요하다.
// 다시 맞추기 위해서는 설명서 (interface 규격)가 필요하다.
// 직렬화를 위해서는 Serializable 이 필요하다.
public class Sample implements Serializable {
	
	int num = 11;
	String team = "EDU";
	String job = "manager";
	
	public String method() {
		return "메서드 호출 하신 분";
	}
}
