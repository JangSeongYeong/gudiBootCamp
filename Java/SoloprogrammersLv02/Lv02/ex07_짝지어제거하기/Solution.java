package Lv02.ex07_짝지어제거하기;
import java.util.Stack;
public class Solution {
	/* 짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 
	 * 
	 * 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 
	 * 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 
	 * 
	 * 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 
	 * 
	 * 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 
	 * 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.
	 * 
	 * 예를 들어, 문자열 S = baabaa 라면
	 * "b aa baa" → "bb aa" → "aa" → ""
	 * 의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다*/
	public int solution(String s) { // 효율성 3,4,5 탈락 (참고로 전부 1이 나와야 통과)
    	// 같은 문자가 붙어있는 경우에만 제거
        String[] eng = {"aa","bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss", "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
        String[] even = {"a","b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String check = s;
        // 각각의 알파벳의 갯수가 짝수가 아니면 0리턴
        if (s.length()%2 != 0) return 0;
        
        for (int i = 0; i < even.length; i++) {
			check = check.replace(even[i], "");
			if (check.length()%2 != 0) return 0;
		}
        
        // 제거 작업
        int length;
        do {
        	length = s.length();
        	for (int i = 0; i < eng.length; i++) {
				s = s.replace(eng[i], "");
        	}
        	// 변했다면 다시 동작
		} while (length != s.length());
        
        return s.equals("") ? 1 : 0;
    }
	
	// GPT로 효율 늘린 코드 *(stack 사용)
	public int solution1(String s) {
        // 스택을 사용하여 짝을 이루는 문자를 찾고 제거
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // 스택이 비어있지 않고, 스택 맨 위의 문자와 현재 문자가 같으면 짝을 이룸 -> 제거
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // 짝을 이루는 문자 제거
            } else {
                stack.push(c); // 스택에 문자 추가
            }
        }
        
        // 짝을 이루는 문자를 모두 제거한 후에 스택이 비어있으면 성공적으로 제거 가능
        return stack.isEmpty() ? 1 : 0;
    }
}