package lv0.ex158_정사각형으로만들기;

public class Solution {
	/*문제 설명
	 * 이차원 정수 배열 arr이 매개변수로 주어집니다. 
	 * arr의 행의 수가 더 많다면 열의 수가 행의 수와 같아지도록 각 행의 끝에 0을 추가하고, 
	 * 열의 수가 더 많다면 행의 수가 열의 수와 같아지도록 각 열의 끝에 0을 추가한 
	 * 이차원 배열을 return 하는 solution 함수를 작성해 주세요.*/
	public int[][] solution(int[][] arr) {
        
        int row = arr[0].length; // 행
        int colum = arr.length; // 열
        int size = row > colum ? row : colum;

        int[][] answer = new int[size][size];
        // 둘이 길이가 같다면 그대로 리턴
        if(row == colum) return arr;
        
        
        // size에 맞춰서 추가
        if(size > row) { // row가 더 작을 때
        	for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if(j < row) {
						answer[i][j] = arr[i][j];
					} else {
						answer[i][j] = 0;
					}					
				}
			}
        } else { // cloum이 더 작을 때
        	for (int i = 0; i < size; i++) {
        		for (int j = 0; j < size; j++) {
					answer[i][j] = arr[i][j];
				}
			}
		}
        
        return answer;
    }
}
