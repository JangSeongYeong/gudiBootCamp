package ex07.test;

import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		
		String[] Babbling = {"aya", "yee", "u", "maa", "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
		
		int cnt = 0;
		for (String str : Babbling) {
			if(Pattern.compile("^(aya(?!aya)|ye(?!ye)|woo(?!woo)|ma(?!ma))+$").matcher(str).find()) {
				cnt++;
			}
		}
		
		System.out.println("cnt : "+cnt);
	}

}
