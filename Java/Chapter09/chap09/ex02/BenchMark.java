package chap09.ex02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BenchMark {

	public static void main(String[] args) {
		
		// 선수 입장
		List<String> arr = new ArrayList<String>();
		List<String> lnk = new LinkedList<String>();
		long startTime = 0;
		long endTime = 0;
		
		// 준비 (데이터를 100개씩 넣는다.)
		for (int i = 1; i <= 100; i++) {
			arr.add("data");
			lnk.add("data");
		}
		
		startTime = System.currentTimeMillis(); // 시간 체크
		// LinkedList 시작
		for (int i = 1; i <= 100000; i++) {
			lnk.add(55, "add data");
		}
		// LinkedList 종료
		endTime = System.currentTimeMillis(); // 시간 체크
		// 도착시간 - 출발시간 = 걸린시간  27ms
		System.out.println("LinkedList 걸린시간 : "+(endTime-startTime)+"ms");
		
		startTime = System.currentTimeMillis(); // 시간 체크
		// ArrayList 시작
		for (int i = 1; i <= 100000; i++) {
			arr.add(55, "add data");
		}
		// ArrayList 종료
		endTime = System.currentTimeMillis(); // 시간 체크
		// 도착시간 - 출발시간 = 걸린시간 1009ms
		System.out.println("ArrayList 걸린시간 : "+(endTime-startTime)+"ms");
		
	}

}
