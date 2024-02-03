package chap09.ex01;

import java.util.ArrayList;
import java.util.List;

public class ArrayList1 {

	public static void main(String[] args) {
		// <> 를 제너릭 이라고 한다.
		// <> 안에 데이터 타입을 넣어서, 해당 클래스 안에서 어떤 데이터를 사용하는지 명시해준다.
		// 단, 데이터 타입은 반드시 클래스 형태로 들어가야 한다. int(X), Integer(O), long(X), Long(O)
 		ArrayList<String> list = new ArrayList<String>();
		
 		
 		// 크기 지정이 가능하다.
 		// 지정된 크기를 넘어가도 상관없다.
 		ArrayList<String> arr = new ArrayList<String>(3);
 		
 		// 이런식으로도 선언이 됩니다.  이유 -> List 라는 최상위 인터페이스가 있기에 다형성에 의해서 List 로 들어가도 상관없다.
 		List<Integer> list2 = new ArrayList<Integer>();
 		
 		
 		// 데이터 추가
 		arr.add("collection"); // 0
 		arr.add("thread"); // 1
 		arr.add("java IO"); // 2
 		arr.add("network"); //3 <- 배열 같았으면 ArrayIndexOutoBoundsException 발생
 		arr.add(3,"lambda");
 		System.out.println(arr); // .toString()을 사용하지 않아도 내용을 보여준다.
	
 		
 		// 크기는 length 가 아닌 size()로 확인한다.
 		
 		// 값을 가져올때는 get(index)를 사용한다.
 		
 		for (int i = 0; i < arr.size(); i++) {
			System.out.println(i+" : " + arr.get(i));
		}
 		
 		
 		// 데이터 삭제 (index 매개변수로 하는것은 지운 값을 알려주고, Object 로 하는 것은 지웠다는 대답을 하는것)
 		String val = arr.remove(2);
 		System.out.println("내가 지운 값 : "+val);
 		
 		// 향상된 for
 		for (String s : arr) {
 			System.out.println(s);
			
		}
 		
	}

}
