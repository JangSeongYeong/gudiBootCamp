package ch09.ex04;

public class Solution {
	boolean solution(String s) {
        boolean answer = true;
        
        
        // 시작 검사하고 걸러내기
        if(s.startsWith(")")) {
        	return false;
        }
        
        /*charAt으로 안하게 되면 유효성 검사에서 막힌다.
         * 
        // 전부 split 으로 나누기
        String[] strList = s.split("");

        // 여닫는것을 카운트하고 이상하면 여는것 + 닫는것 - 0보다 크면 false
        int count = 0;
        for (String str : strList) {
			if(str.equals("(")) {
				count++;
			} else {
				if(count>0){
					count--;
				}else{
					return false;
				}
			}
		}
		
		if (count == 0){
			return  true;
		} else {
			return  false;
		}
		
        */
        
        int sum = 0;
        for (int i = 0; i<s.length(); i++) {
        	if(s.charAt(i)=='(') {
        		sum++;
        	} else {
        		if(sum>0) {
        			sum--;        			
        		}else {
					return false;
				}
			}
        }
        
        return answer = sum == 0;
        
    }
}
