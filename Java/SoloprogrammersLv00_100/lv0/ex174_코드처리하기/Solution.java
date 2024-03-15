package lv0.ex174_코드처리하기;

public class Solution {
	/* mode가 0일 때 
	 * code[idx]가 "1"이 아니면 idx가 짝수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
	 * code[idx]가 "1"이면 mode를 0에서 1로 바꿉니다.
	 * 
	 * mode가 1일 때
	 * code[idx]가 "1"이 아니면 idx가 홀수일 때만 ret의 맨 뒤에 code[idx]를 추가합니다.
	 * code[idx]가 "1"이면 mode를 1에서 0으로 바꿉니다.
	 * 
	 * 문자열 code를 통해 만들어진 문자열 ret를 return 하는 solution 함수를 완성해 주세요.
	 * 단, 시작할 때 mode는 0이며, return 하려는 ret가 
	 * 만약 빈 문자열이라면 대신 "EMPTY"를 return 합니다.
	 * */
    public String solution(String code) {
        String[] cs = code.split("");
    	StringBuffer buffer = new StringBuffer();
        int flag = 0;
        
    	for (int i = 0; i < cs.length; i++) {
    		if (cs[i].equals("1")) {
    			flag = flag == 0 ? 1 : 0;
    		} else if (flag == 0 && i%2==0) {
				buffer.append(cs[i]);
			} else if (flag == 1 && i%2==1) {
				buffer.append(cs[i]);
			} 
		}
        
        return buffer.toString().equals("") ? "EMPTY" : buffer.toString();
    }
}