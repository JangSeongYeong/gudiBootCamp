package ch09.ex02;

import java.util.HashMap;

public class Solution {
	public long solution(String numbers) {
		// "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
		long answer = 0;
        
		/*
		// 문자열에 중복으로 있다고 하더라도 둘다 바꿔준다는 것을 확인완료
		numbers = numbers.replace("zero", "0");
		numbers = numbers.replace("one", "1");
		numbers = numbers.replace("two", "2");
		numbers = numbers.replace("three", "3");
		numbers = numbers.replace("four", "4");
		numbers = numbers.replace("five", "5");
		numbers = numbers.replace("six", "6");
		numbers = numbers.replace("seven", "7");
		numbers = numbers.replace("eight", "8");
		numbers = numbers.replace("nine", "9");	

		// String 을 long 으로 변경
		answer = Long.parseLong(numbers);
                
        return answer;
        */
		
		/*
		// 위에 코드 간소화(배열 사용) (0.11ms ~ 0.17ms)
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < arr.length; i++) {
        	numbers = numbers.replace(arr[i], String.valueOf(i));	// 숫자를 문자로 바꾸는 메서드 String.valueOf(Integer)
		}
        
        answer = Long.parseLong(numbers);
        return answer;
        */
		
		// 2. HashMap (0.40ms~0.79ms)
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("zero", "0");
		map.put("one", "1");
		map.put("two", "2");
		map.put("three", "3");
		map.put("four", "4");
		map.put("five", "5");
		map.put("six", "6");
		map.put("seven", "7");
		map.put("eight", "8");
		map.put("nine", "9");
       
		for (String key : map.keySet()) {
			numbers = numbers.replace(key, map.get(key));
		}
		
		answer = Long.parseLong(numbers);
        return answer;
        
	}
}
