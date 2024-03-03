package lv0.ex159_외계어사전;

import java.util.ArrayList;

public class Solution {
	/* PROGRAMMERS-962 행성에 불시착한 우주비행사 머쓱이는 외계행성의 언어를 공부하려고 합니다. 
	 * 알파벳이 담긴 배열 spell과 외계어 사전 dic이 매개변수로 주어집니다. 
	 * spell에 담긴 알파벳을 한번씩만 모두 사용한 단어가 dic에 존재한다면 1, 
	 * 존재하지 않는다면 2를 return하도록 solution 함수를 완성해주세요.*/
	public int solution(String[] spell, String[] dic) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < dic.length; i++) list.add(dic[i]);
		
		// 단어 수
		int length = spell.length;
        
		for (int i = 0; i < list.size(); i++) {
			// 매개변수가 단어 수에 적합한지 확인
			if (length != list.get(i).length()) {
				list.remove(i);
				i--;
			} else {
				// 인덱스 위치 비교 후 다르다면 삭제
				for (int j = 0; j < length; j++) {
					if(list.get(i).indexOf(spell[j]) == -1 || list.get(i).indexOf(spell[j]) != list.get(i).lastIndexOf(spell[j])) {
						list.remove(i);
						i--;
						break;
					}
				}
			}
		}
		return list.size() > 0 ? 1 : 2;
    }
}