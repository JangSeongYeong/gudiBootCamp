package lv0.ex118_A로B만들기;

import java.util.Arrays;

public class Solution {
	/*문자열 before와 after가 매개변수로 주어질 때, 
	 * before의 순서를 바꾸어 after를 만들 수 있으면 1을, 
	 * 만들 수 없으면 0을 return 하도록 solution 함수를 완성해보세요.*/
	public int solution(String before, String after) {
        
        String[] befores = before.split("");
        String[] afters = after.split("");
        
        Arrays.sort(befores);
        Arrays.sort(afters);
        
        for (int i = 0; i < befores.length; i++) {
			if(!befores[i].equals(afters[i])) {
				return 0;
			}
		}
        
        return 1;
    }
}
