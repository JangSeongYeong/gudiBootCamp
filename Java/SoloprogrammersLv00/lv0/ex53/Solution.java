package lv0.ex53;
// 암호 해독
public class Solution {
	/*군 전략가 머쓱이는 전쟁 중 적군이 다음과 같은 암호 체계를 사용한다는 것을 알아냈습니다.
	암호화된 문자열 cipher를 주고받습니다.
	그 문자열에서 code의 배수 번째 글자만 진짜 암호입니다.
	문자열 cipher와 정수 code가 매개변수로 주어질 때 해독된 암호 문자열을 return하도록 solution 함수를 완성해주세요.*/
	public String solution(String cipher, int code) {
        StringBuffer buffer = new StringBuffer();
        
        // char 배열
        char[] clist = cipher.toCharArray();
        int count = 1;
        // code 배수 번째 문자 더해주기
        for (int i = 0; i < clist.length; i++) {
        	if (count == code) {
				buffer.append(clist[i]);
				count = 0;
			}
        	count++;
		}
        
        // 리턴
        return buffer.toString();
    }
}
