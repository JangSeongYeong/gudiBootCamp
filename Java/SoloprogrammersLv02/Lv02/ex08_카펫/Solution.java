package Lv02.ex08_카펫;

public class Solution {
	/* 카펫은 중앙은 노랑 갈색은 테두리만
	 * 
	 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
	 * 전체 카펫의 크기는 기억하지 못했습니다.
	 * 
	 * Leo가 본 카펫에서 갈색 격자의 수 brown, 
	 * 노란색 격자의 수 yellow가 매개변수로 주어질 때 
	 * 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.*/
   
	// 노란색 1 이상 2000000이하    갈색 8 이상 5000이하 ,    가로 세로는 같거나 가로가 더 길다
	
	public int[] solution(int brown, int yellow) {
        int row = 1;
        // brown 에서 2를 빼고 반으로 나눠 나오는 내부의 공간이 yellow 와 같은지 확인하기
        int column = (brown-row*2)/2;
        
        // 같지 않다면 2를 한번 더 빼서 내부공간이랑 확인해보기
        while (row*(column-2) != yellow) {
        	row++;
        	column = (brown-row*2)/2;
		}
        
        return new int[] {column, row+2};
    }
}