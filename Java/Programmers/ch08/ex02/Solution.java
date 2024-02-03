package ch08.ex02;

public class Solution {
	
	public String solution(String my_string, int n) {
        String answer = "";
        
        char[] charArr = new char[my_string.length()*n];
        int index = 0;
        // 0.02ms~0.05ms
        for(int i = 0; i<my_string.length(); i++) {
        	// 각각의 문자를 뽑아내고 n번 번복해서 넣기
        	for (int j = 0; j < n; j++) {
        		charArr[index] = my_string.charAt(i);
				index++;
			}
        }
        answer = new String(charArr);
        
        // answer = answer + char 이런식으로 더하게되거나
        // for 문을 잘못활용하면 시작이 오래걸리게 된다. 
        // 보기에는 객체를 불러오면 오래걸리게 되는 것 같다.
    
        // 각 문자를 봅아내기
        String[] arr = my_string.split("");
        StringBuffer buffer = new StringBuffer();
        
        // 뽑아낸 문자를 n번 반복 (0.18ms~0.26ms)
        for(String str : arr) {
        	// 반복된 문자를 answer에 합치기
        	// buffer.append(str.repeat(n));
        	for (int i = 0; i < n; i++) {
				buffer.append(str); // (0.15ms~0.21ms)
			}
        }
        answer = buffer.toString();
        
        return answer;
	}
}
