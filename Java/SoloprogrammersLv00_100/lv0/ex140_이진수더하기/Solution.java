package lv0.ex140_이진수더하기;

import java.util.ArrayList;

public class Solution {
	/*이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때, 
	 * 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.*/
	public String solution(String bin1, String bin2) {
        StringBuffer buffer = new StringBuffer();
		
        if (bin1.equals("0")) {
			return bin2;
		} else if (bin2.equals("0")) {
			return bin1;
		}
        
        ArrayList<Character> b1 = new ArrayList<Character>();
        ArrayList<Character> b2 = new ArrayList<Character>();
        ArrayList<Character> result = new ArrayList<Character>();
        // 긴 사이즈 구하기
        int size = bin1.length() > bin2.length() ? bin1.length() : bin2.length();
        
        // 배열을 역순으로 바꾸기
        for (int i = bin1.length()-1; i >= 0; i--) {
			b1.add(bin1.charAt(i));
		}
        // 남은 크기는 0으로 채우기
        for (int i = bin1.length(); i < size; i++) {
        	b1.add('0');
		}
        
        for (int i = bin2.length()-1; i >= 0; i--) {
        	b2.add(bin2.charAt(i));
		}
        for (int i = bin2.length(); i < size; i++) {
        	b2.add('0');
		}
        System.out.println(b1);
        System.out.println(b2);
        
        // 1 + 1 이 되었을때 올리는 용
        int up = 0;
        
        for (int i = 0; i <= size; i++) {
        	// 마지막 일때
        	if (i == size) {
				if (up == 1) {
					result.add('1');
				} 
        		break;
			}
        	
			if(b1.get(i) == '1' &&  b2.get(i) == '1') {
				if(up == 1) {
					up = 1;
					result.add('1');
				} else {
					up = 1;
					result.add('0');
				}
			} else if (b1.get(i) == '1' || b2.get(i) == '1') {
				if(up == 1) {
					up = 1;
					result.add('0');
				} else {
					result.add('1');
				}
			} else {
				if(up == 1) {
					result.add('1');
					up = 0;
				} else {
					result.add('0');
				}
			}
		}
        
        for (int i = result.size()-1; i >=0; i--) {
			buffer.append(result.get(i));
		}
        
        return buffer.toString();
    }
}
