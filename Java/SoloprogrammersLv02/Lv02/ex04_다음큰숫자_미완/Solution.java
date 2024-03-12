package Lv02.ex04_다음큰숫자_미완;

public class Solution {
	/* 자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.
	 * 
	 * 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
	 * 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
	 * 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
	 * 
	 * 예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.
	 * 
	 * 자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요*/
    public int solution(int n) {
    	StringBuffer buffer = new StringBuffer();
        int next = n;
        
        // (int)Math.pow 를 통해서 문자열을 생성
        int pow = 0;
        while (Math.pow(2, pow) < n) {
        	pow++;
		}
        pow = pow-1;
        
        int npow = pow;
        // 0을 제거 후 length를 비교
        while (npow >= 0) {
			buffer.append(n/(int)(Math.pow(2, npow)));
			n = n%(int)(Math.pow(2, npow));
			npow--;
		}
        // 1의 값만 남기기
        int cnt1 = buffer.toString().replace("0", "").length();
        buffer.delete(0, buffer.length());
        
        // n보다 큰 수 중에서 1의 값이 같은 코드 찾기
        int nextSave = 0;
        int nextPow = pow;
        int cnt2 = 0;
        while (cnt1 != cnt2) {
        	nextPow = pow;
        	next++;
        	nextSave = next;
        	while (nextPow >= 0) {
        		buffer.append(nextSave/(int)(Math.pow(2, nextPow)));
        		nextSave = nextSave%(int)(Math.pow(2, nextPow));
        		nextPow--;
    		}
        	
        	cnt2 = buffer.toString().replace("0", "").length();
        	buffer.delete(0, buffer.length());
		}
        
        // 리턴
        return next;
    }
}