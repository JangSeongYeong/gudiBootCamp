package Lv02.ex11_N개의최소공배수;

public class Solution {
	/* 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미 
	 * 
	 *  n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성
	 * */
    public int solution(int[] arr) {
    	int answer = 1;
        boolean flag = true;
        while (flag) {
        	answer++;
        	for (int i = 0; i < arr.length; i++) {
        		if (answer%arr[i] != 0) break;
        		if (i == arr.length-1 && answer%arr[i] == 0) flag = false;
			}
		}
        
        return answer;
    }
}