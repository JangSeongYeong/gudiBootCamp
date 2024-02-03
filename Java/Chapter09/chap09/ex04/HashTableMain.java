package chap09.ex04;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class HashTableMain {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new Hashtable<String, Integer>();
		
		map.put("김철수", 99);
		map.put("박동빈", 80);
		map.put("박은빈", 75);
		map.put("신솔비", 43);
		map.put("한은정", 52);
		map.put("김민지", 100);
		map.put("김윤경", 80);
		map.put("정철수", 99);
		map.put("안은호", 87);
		map.put("최영일", 75);
		
		// containsKey(key) : 특정 키가 존재 하는지
		// get(key) : 해당 키에 대한 값을 가져와라
		boolean contain =  map.containsKey("김민지");
		System.out.println("김민지가 있니? "+contain);
		
		// containsValue(value) : 특정한 값이 존재 하는지
		contain = map.containsValue(98);
		System.out.println("98점인 학생이 있니? "+contain);
		
		// get 을 이용하면 키로써 값을 찾을 수 있지만
		// 값으로써 키를 찾는 방법은 없다. (예: 99점 학생은 누구누구인가?)
		
		// 99점 학생은 누구인가?
		// Map 을 Entry 로 나눈다 -> iterator 로 쪼갠다. -> 반복하며 entry 의 value 와 설정 값이 같을때 반환한다.
		
		/* 내가 한거
		Set<Entry<String, Integer>> enteySet = map.entrySet();
		Iterator<Entry<String, Integer>> iterator = enteySet.iterator();
		int search = 99;
		
		
		while (iterator.hasNext()) { 
			Entry<String, Integer> entry = iterator.next();
			if(entry.getValue() == search) {
				System.out.println(search+"점 학생은 "+entry.getKey()+"입니다.");				
			}
		}
		*/
		
		// 강사님이 한거
		for (String key : map.keySet()) {
			int val = map.get(key);
			if(val == 99) {
				System.out.println(val+"점인 학생 : "+key);
			}
		}
		
		// entrySet 으로 나누고 iterator 나누는것을 축약한 경우
		for (Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int val = entry.getValue();
			if(val == 99) {
				System.out.println(val+"점인 학생 : "+key);
			}
		}
		
	}

}
