package ch09.ex03;

import java.util.Arrays;

public class Solution {
	public int solution(int[] a, int[] b)
    {
        int answer = 0;
        /*
        // 이중 for 로 정렬 -> 유효성 검사에서 막힘 너무 큰수면 안되서
        int temp = 0;
        
        for (int i = 0; i < a.length; i++) {
			for (int j = 0 + i; j < a.length; j++) {
				if(j+1 <= a.length-1 && a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			} 
		}
        
        for (int i = 0; i < b.length; i++) {
			for (int j = 0 + i; j < b.length; j++) {
				if(j+1 <= b.length-1 && b[j+1] < b[j] ) {
					temp = b[j];
					b[j] = b[j+1];
					b[j+1] = temp;
				}
			} 
		}
        
        */
        // 오름차순 정렬 (Sort), 내림차순 (reverseOrder)
        Arrays.sort(a);
        Arrays.sort(b);
        
        for (int i = 0; i < b.length; i++) {
			answer += a[i] * b[b.length-i-1];
		}
        
        return answer;
        
    }
}
