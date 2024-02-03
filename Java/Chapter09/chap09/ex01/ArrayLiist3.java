package chap09.ex01;

import java.util.List;
import java.util.Vector;

public class ArrayLiist3 {

	public static void main(String[] args) {
		// 데이터 수정, 검색, 비우기
		
		// ArrayList == Vector, Vector 는 동시 접근을 막는다.
		List<Integer> score = new Vector<Integer>();
		
		score.add(70);
		score.add(80);
		score.add(90);
		score.add(100);
		score.add(50);
		score.add(90);
		
		// set(index, value) : 특정 인덱스의 데이터 변경
		int prev = score.set(3, 95);
		System.out.println("기존 값 : " +prev);
		System.out.println(score);
		
		// contains : 특정 값이 포함되어 있는지 boolean 으로 반환
		System.out.println(score.contains(30));
		
		// indexOf() : 특정 값의 위치를 알려줌(없으면 -1)
		System.out.println(score.indexOf(90));
		
		
		// isEmpty : 비어 있는지 확인 후 boolean 으로 반환
		System.out.println(score.isEmpty());
		// clear : 리스트에 있는 모든 값을 비운다.
		score.clear();
		System.out.println(score.isEmpty());
		
		
		
	}

}
