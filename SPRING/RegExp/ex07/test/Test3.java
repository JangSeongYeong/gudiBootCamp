package ex07.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {

	public static void main(String[] args) {
		
		int answer = 0;
		
		// 정규표현식 only
		String str1 = "aAb1B2cC34oOp";
		Matcher m =  Pattern.compile("(\\d)").matcher(str1);
		while (m.find()) {
			answer += Integer.parseInt(m.group());
		}
		System.out.println(answer);
		
		// 정규표현식 + replaceAll
		answer = 0;
		String str2 = "1a2b3c4d123";
		for (String num : str2.replaceAll("[^\\d]", "").split("")) {
			answer += Integer.parseInt(num);
		}
		System.out.println(answer);
		
	}

}
