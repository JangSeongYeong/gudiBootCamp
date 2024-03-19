package lv01.ex45_1차_비밀지도;

public class Solution {
	/* 지도 암호 해독
	 * 1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
	 * 
	 * 2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 
	 * 		각각 "지도 1"과 "지도 2"라고 하자. 
	 * 		지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
	 * 		지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
	 * 
	 * 3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다
	 * 
	 * 4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
	 * 
	 * 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
	 * */
	
	/* 입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
	 * 1 ≦ n ≦ 16
	 * 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
	 * */
	
	/* 원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라. */
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] arr1sec= new String[n];
        String[] arr2sec= new String[n];
        
        StringBuffer buffer = new StringBuffer();
        int result = 0;
        int maxsec = (int)Math.pow(2, n-1); // 최대 2진수 값
        // 각 배열의 원소를 2진수 문자열로 변환
        for (int i = 0; i < arr1.length; i++) {
			result = arr1[i];
			int div = maxsec;
        	for (int j = 0; j < n; j++) {
				buffer.append(String.valueOf(result/div));
				result %= div;
				div /= 2;
			}
        	arr1sec[i] = buffer.toString();
        	buffer.delete(0, buffer.length());
		}
        
        for (int i = 0; i < arr2.length; i++) {
			result = arr2[i];
			int div = maxsec;
        	for (int j = 0; j < n; j++) {
				buffer.append(String.valueOf(result/div));
				result %= div;
				div /= 2;
			}
        	arr2sec[i] = buffer.toString();
        	buffer.delete(0, buffer.length());
		}
        
        // 각 배열의 원소를 더하기가 아닌 합치기
        String[] answer = new String[n];
        String append = "";
        for (int i = 0; i < answer.length; i++) {
        	for (int j = 0; j < n; j++) {
        		// 1을 #으로 0을 공백으로
        		append = arr1sec[i].charAt(j) == '1' || arr2sec[i].charAt(j) == '1' ? "#" : " ";
        		buffer.append(append);
			}
        	answer[i] = buffer.toString();
        	buffer.delete(0, buffer.length());
		}
        
        return answer; 
    }
}