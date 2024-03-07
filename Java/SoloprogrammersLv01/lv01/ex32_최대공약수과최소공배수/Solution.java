package lv01.ex32_최대공약수과최소공배수;

//import java.math.BigInteger;

public class Solution {
	/* 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
	 * 
	 * 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
	 * 
	 * 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 
	 * solution(3, 12)는 [3, 12]를 반환해야 합니다.
	 * 
	 * 두 수는 1이상 1000000이하의 자연수입니다.
	 * */
    public int[] solution(int n, int m) {
    	int[] answer = new int[2];
    	int max = n > m ? n : m;
    	int min = n < m ? n : m;
        
    	// 최대 공약수 구하기
    	for (int i = 1; i <= min; i++) {
			if (min % i == 0 && max % i == 0) {
				answer[0] = i;
			}
		}
    	
//    	BigInteger a = BigInteger.valueOf(min);
//    	BigInteger b = BigInteger.valueOf(max);
//    	answer[0] = a.gcd(b).intValue();
    	
    	int mul = max;
        // 최소 공배수 구하기
    	for (int i = 1; mul % min != 0; i++) {
    		mul = max * i;
    	}
    	answer[1] = mul;
        
        return new int[] {answer[0], answer[1]};
    }
}