package Lv02.ex06_영어끝말잇기;

import java.util.HashSet;

public class Solution {
	/* 1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
	 * 마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
	 * 앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
	 * 이전에 등장했던 단어는 사용할 수 없습니다.
	 * 한 글자인 단어는 인정되지 않습니다.*/
	
	/* 끝말잇기는 다음과 같이 진행됩니다.
	 * 1번 사람이 자신의 첫 번째 차례에 tank를 말합니다.
	 * 2번 사람이 자신의 첫 번째 차례에 kick을 말합니다.
	 * 3번 사람이 자신의 첫 번째 차례에 know를 말합니다.
	 * 1번 사람이 자신의 두 번째 차례에 wheel을 말합니다.
	 * (계속 진행)*/
	
	/* 끝말잇기를 계속 진행해 나가다 보면, 
	 * 3번 사람이 자신의 세 번째 차례에 말한 tank 라는 단어는 이전에 등장했던 단어이므로 탈락하게 됩니다.
	 * 
	 * 사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때, 
	 * 가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.*/
	
	/* 정답은 [ 번호, 차례 ] 형태로 return 해주세요.
	 * n은 2 이상 10 이하 자연수
	 * 
	 * 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
	 * 
	 * 시작 알파벳이 틀리면 그것도 끝
	 * */
    public int[] solution(int n, String[] words) {
    	// answer[0] -> 몇번째 사람인지
    	// answer[1] -> 몇번재 턴인지
    	int[] answer = {0, 1};
    	HashSet<String> set = new HashSet<String>();
    	for (String str : words) {
			set.add(str);
		}
    	
    	int cnt = 1;
    	boolean retire = false;
    	char lastch = words[0].charAt(words[0].length()-1);
    	set.remove(words[0]);
    	for (int i = 1; i < words.length; i++) {
    		cnt++;
    		// 탈락 조건 1. 같은 단어
    		if(!set.remove(words[i])) {
    			answer[0] = cnt;
    			retire = true;
    			break;
    		}
    		
    		// 탈락 조건 2. 시작 알파벳이 틀렸을경우
    		if (lastch != words[i].charAt(0)) {
				answer[0] = cnt;
				retire = true;
    			break;
			}
    		
    		// 마지막 글자 수정
    		lastch = words[i].charAt(words[i].length()-1);
    		
    		
    		// 마지막 인원까지 했을 경우 다음 턴
    		if(cnt == n) {
    			cnt = 0;
    			answer[1]++;
    		}
    		
		}
    	if(set.size() == 0 && !retire) {
    		return new int[] {0,0};
    	}
        
        return answer;
    }
}