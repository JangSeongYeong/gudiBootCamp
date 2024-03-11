package Lv02.ex02_이진변환반복하기;

public class Solution {
	/* 0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.
	 * 
	 * 1. x의 모든 0을 제거합니다.
	 * 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
	 * 
	 * 예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 
	 * x = "0111010" -> "1111" -> "100" 이 됩니다.
	 * 
	 * 0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. 
	 * s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 
	 * 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 
	 * 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
	 * 
	 * */
    public int[] solution(String s) {
        int[] answer = {0, 0};
        // [0] -> 이진 변환의 횟수 , [1] ->제거된 모든 0의 개수
        int[] list = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768,65536,131072};
        String num = s;
        char[] clist;
        int size;
        while (!num.equals("1")) {
        	answer[0]++;
        	// 0 없애기 [0]
        	clist = num.toCharArray();
        	for (int i = 0; i < clist.length; i++) {
				if (clist[i] == '0') answer[1]++;
        	}
			num = num.replace("0", "");
			// 길이 측정
			size = num.length();
			// 길이 2진수로 변환 -> 반복 (cnt 세기)
			num = "";
			for (int i = list.length-1; i >= 0; i--) {
				if(size/list[i] != 0) {
					for (int j = i; j >= 0; j--) {
						num = num + size/list[j];
						size = size  % list[j];
					}
					break;
				}
			}
		}
        
        return answer;
    }
}