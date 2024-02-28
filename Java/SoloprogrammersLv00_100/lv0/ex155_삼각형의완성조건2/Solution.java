package lv0.ex155_삼각형의완성조건2;

import java.util.Arrays;

public class Solution {
	/*선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
	가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
	삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 
	나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.*/
	public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        int[] copy = new int[] {sides[0], sides[1]};
        
        // 가장 긴변은 둘의 합보다 같거나 작아야함
        
        // 가장 긴 변이 sides[1]일 경우
        int start = sides[1]-sides[0];
        while (start != sides[1]) {
        	start++;
        	answer++;
        	System.out.println(start);
		}
        
        // 가장 긴변이 나머지 한변일 경우
        while (copy[0]+copy[1]-1 > sides[1]) {
			sides[1]++;
			answer++;
		}
        
        return answer;
    }
}
