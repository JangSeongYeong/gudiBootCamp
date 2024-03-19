package Lv02.ex09_점프와순간이동;

public class Solution {
	/* k칸 점프      OR      (현재까지 온 거리) * 2 에 해당하는 위치로 순간이동 
	 * 순간이동은 배터리 사용 X
	 * k칸 점프하면 k 만큼의 건전지 사용량이 든다
	 * 
	 * n 만큼 이동하려고 할때 사용해야하는 건전지의 사용량의 최솟값
	 * 
	 * */
	
    public int solution(int n) {
        int ans = 0;

        while (n>0) {
			if(n%2 != 0) ans++;
			n/=2;
		}
        
        return ans;
    }
}