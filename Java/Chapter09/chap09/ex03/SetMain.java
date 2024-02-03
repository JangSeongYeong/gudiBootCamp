package chap09.ex03;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		// set 은 중복을 허용하지 않고, 순서도 없다.
		set.add("JAVA");
		set.add("JSP");
		set.add("MARIA");
		set.add("SPRING");
		set.add("JAVA"); // 중복
		System.out.println(set+" : "+set.size());
		
		HashSet<Member> member = new HashSet<Member>();
		member.add(new Member()); // 각 객체는 복사본 이므로 기본적으로 다르다고 판단
		member.add(new Member()); // 둘 다 같은 클래스로 객체화 했지만 일련번호는 다르다. equals 를 사용하는 것과 같은 원리
		System.out.println(member.size());
		
		// 요소 삭제
		set.remove("MARIA");
		
		// 요소를 하나씩 뽑아내는 방법 1 : 정식적인 방법
		Iterator<String> iter = set.iterator(); // iterator 를 사용해 덩어리를 쪼갬, set 은 덩어리로 되어있음
		
		while (iter.hasNext()) { // 가져올 값이 있는지 (true/false) 확인
			System.out.println(iter.next()); // next 로 가져온다.
		}
		
		System.out.println();
		
		// 요소를 하나씩 뽑아내는 방법 2 : 향상된 for
		// set 을 바로 넣음으로 알아서 쪼개 준다.
		for (String s : set) {
			System.out.println(s);
		}
		
		//isEmpty()
		//clear()
		// 검색을 제외한 List 에 있는 메서드들은 있다.
	}

}

class Member{
	
}