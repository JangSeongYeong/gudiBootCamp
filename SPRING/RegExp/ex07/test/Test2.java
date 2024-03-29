package ex07.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		
		String str1 = "bus";
		String str2 = "nice to meet you";
		Matcher m = null;
		
		String result = "";
		m = Pattern.compile("[^aeiou]").matcher(str1);
		while (m.find()) {
			result += m.group();
		}
		str1 = str1.replaceAll("[aeiou]", "");
		System.out.println(str1);
		System.out.println(result);
		
		result = "";
		m = Pattern.compile("[^a|^e|^i|^o|^u]").matcher(str2);
		while (m.find()) {
			result += m.group();
		}
		System.out.println(result);
		
		
	}

}
