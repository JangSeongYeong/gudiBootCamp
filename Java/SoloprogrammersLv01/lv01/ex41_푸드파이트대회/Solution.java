package lv01.ex41_푸드파이트대회;

public class Solution {
	/* 대결은 준비된 음식들을 일렬로 배치한 뒤, 
	 * 한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로, 
	 * 다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다. 
	 * 중앙에는 물을 배치하고, 물을 먼저 먹는 선수가 승리*/
	
	/* 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다*/
	/* food[0] 은 항상 물이며 1이다
	 * 
	 * food 길이는 2~9
	 * food 원소는 1~1000 (음식수)
	 * */
    public String solution(int[] food) {
        StringBuffer buffer = new StringBuffer();
        
        int[] food2div = new int[food.length-1];
        for (int i = 1; i < food.length; i++) {
			food2div[i-1] = food[i]/2;
		}
        
        for (int i = 0; i < food2div.length; i++) {
			buffer.append(String.valueOf(i+1).repeat(food2div[i]));
		}
        buffer.append("0");
        
        for (int i = food2div.length-1; i >= 0; i--) {
        	buffer.append(String.valueOf(i+1).repeat(food2div[i]));
		}
        
        return buffer.toString();
    }
}