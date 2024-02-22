package lv0.ex38;

public class Solution {
	/*연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
	12 ⊕ 3 = 123
	3 ⊕ 12 = 312
	양의 정수 a 와 b 가 주어졌을 때, a ⊕ b 와 2 * a * b 중 더 큰 값을 
	return 하는 solution 함수를 완성해 주세요.

	단, a ⊕ b 와 2 * a * b 가 같으면 a ⊕ b 를 return 합니다.*/
	public int solution(int a, int b) {
        int answer = 0;
        StringBuffer buffer = new StringBuffer();
        buffer.append(a);
        buffer.append(b);
        String bufStr = buffer.toString();
        int bufInt = Integer.parseInt(bufStr);
        
        if (bufInt >= 2*a*b) {
			answer = bufInt;
		} else {
			answer = 2*a*b;
		}
        
        return answer;
    }
}
