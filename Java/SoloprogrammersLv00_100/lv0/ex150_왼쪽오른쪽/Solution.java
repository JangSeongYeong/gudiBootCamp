package lv0.ex150_왼쪽오른쪽;

public class Solution {
	/*문자열 리스트 str_list에는 "u", "d", "l", "r" 네 개의 문자열이 여러 개 저장되어 있습니다. 
	 * str_list에서 "l"과 "r" 중 먼저 나오는 문자열이 "l"이라면 
	 * 해당 문자열을 기준으로 왼쪽에 있는 문자열들을 순서대로 담은 리스트를, 
	 * 
	 * 먼저 나오는 문자열이 "r"이라면 
	 * 해당 문자열을 기준으로 오른쪽에 있는 문자열들을 순서대로 담은 리스트를 return 하도록 solution 함수를 완성해주세요. 
	 * 
	 * "l"이나 "r"이 없다면 빈 리스트를 return 합니다.*/
	public String[] solution(String[] str_list) {
		
		// 문자열로 만들기
		StringBuffer buffer = new StringBuffer();
		for (String str : str_list) {
			buffer.append(str);
		}
		
		String str = buffer.toString();
        
		// indexOf 로 가까운값
		int ridx = str.indexOf("r");
		int lidx = str.indexOf("l");
		System.out.println(ridx);
		System.out.println(lidx);
		
		
		String[] answer;
		// 둘다 못찾았을 때
		if (ridx == -1 && lidx == -1) {
			return new String[] {};
		} else if((lidx < ridx || ridx == -1) && lidx != -1) {
			// "ㅣ"을 더 빨리 찾았을때
			answer = new String[lidx];
			for (int i = 0; i < lidx; i++) {
				answer[i] = str_list[i];
			}
		} else {
			// "r"을 더 빨리 찾았을때
			answer = new String[str_list.length-ridx-1];
			for (int i = 0; i < str_list.length-ridx-1; i++) {
				answer[i] = str_list[ridx+1+i];
			}
		}
		
        return answer;
    }
}
