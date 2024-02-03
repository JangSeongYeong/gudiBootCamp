package ch09.ex01;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public String solution(String letter) {
		String answer = "";

		Map<String, String> morse = new HashMap<String, String>();
		morse.put(".-","a");
		morse.put("-...","b");
		morse.put("-.-.","c");
		morse.put("-..","d");
		morse.put(".","e");
		morse.put("..-.","f");
		morse.put("--.","g");
		morse.put("....","h");
		morse.put("..","i");
		morse.put(".---","j");
		morse.put("-.-","k");
		morse.put(".-..","l");
		morse.put("--","m");
		morse.put("-.","n");
		morse.put("---","o");
		morse.put(".--.","p");
		morse.put("--.-","q");
		morse.put(".-.","r");
		morse.put("...","s");
		morse.put("-","t");
		morse.put("..-","u");
		morse.put("...-","v");
		morse.put(".--","w");
		morse.put("-..-","x");
		morse.put("-.--","y");
		morse.put("--..","z");

		String[] letters = letter.split(" ");

		StringBuilder builder = new StringBuilder();
		for (String str : letters) {
			builder.append(morse.get(str)); // 검색하면 되는데 나는 왜 비교를 하려고 했을까
		}

		answer = builder.toString();

		return answer;
	
	}
}


