package lv0.ex132_문자열묶기;

import java.util.Arrays;

public class Solution {
	/*문자열 배열 strArr이 주어집니다. 
	 * strArr의 원소들을 길이가 같은 문자열들끼리 
	 * 그룹으로 묶었을 때 가장 개수가 많은 그룹의 크기를 return 하는 solution 함수를 완성해 주세요.
	 *  원소의 길이 1~30
	 * */
	public int solution(String[] strArr) {
        // 그룹마다 관리할 배열을 만들고 전부 0 추가
		int[] group = new int[30];
        
        for (int i = 0; i < group.length; i++) {
			group[i] = 0;
		}
        
        
        for (String str : strArr) {
			group[str.length()-1]++;
		}
        
        Arrays.sort(group);

        return group[29];
    }
}
