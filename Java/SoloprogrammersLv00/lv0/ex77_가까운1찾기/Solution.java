package lv0.ex77_가까운1찾기;

public class Solution {
	/*정수 배열 arr가 주어집니다. 이때 arr의 원소는 1 또는 0입니다. 
	 * 정수 idx가 주어졌을 때, 
	 * idx보다 크면서 배열의 값이 1인 가장 작은 인덱스를 찾아서 반환하는 solution 함수를 완성해 주세요.
	 * 단, 만약 그러한 인덱스가 없다면 -1을 반환합니다.*/
	public int solution(int[] arr, int idx) {
        int answer = -1;
        // idx보다 큰 인덱스에 있는 값중 1인 idx 반환
        // 없으면 -1 반환
        
        for (int i = idx; i < arr.length; i++) {
			if(arr[i] == 1) {
				answer = i;
				break;
			}
		}
        
        return answer;
    }
}
