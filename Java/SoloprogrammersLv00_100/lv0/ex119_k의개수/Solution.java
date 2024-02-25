package lv0.ex119_k의개수;

public class Solution {
	/*1부터 13까지의 수에서, 1은 1, 10, 11, 12, 13 이렇게 총 6번 등장합니다. 
	 * 정수 i, j, k가 매개변수로 주어질 때, i부터 j까지 k가 몇 번 등장하는지 return 하도록 solution 함수를 완성해주세요.*/
	public int solution(int i, int j, int k) {
        int answer = 0;
        String[] slist;
        
        for (int l = i; l <= j; l++) { 
        	slist = Integer.toString(l).split("");
        	for (int idx = 0; idx < slist.length; idx++) {
				if (slist[idx].equals(Integer.toString(k))) {
					answer++;
				}
			}
		}
        
        return answer;
    }
}
