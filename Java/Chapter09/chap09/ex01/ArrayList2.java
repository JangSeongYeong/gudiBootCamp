package chap09.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayList2 {

	// 배열을 ArrayList 에 옮기고 싶을 때
	public static void main(String[] args) {
		// array -> List -> ArrayList
		
		// Array -> List
		String[] arr = {"List", "Map", "Set"};
		List<String> list = Arrays.asList(arr); // 배열을 리스트처럼 '모양'만 바꾼것, to 가 아니라 as 라는 것에 주의
		System.out.println(list.size());
		System.out.println(list.get(1));
//		list.add("Collection"); // Array 를 List로 변환하고 나면 수정은 불가능 하다.
		
		// List -> ArrayList
		ArrayList<String> arrList = new ArrayList<String>();
		arrList.addAll(list); // list를 arrList에 전부 넣음 
		arrList.add("Collection");
		System.out.println(arrList);
		
	}

}
