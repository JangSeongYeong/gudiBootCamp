package ex07.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test4 {

	public static void main(String[] args) {
		
		String[] numbers = {"01033334444", "027778888"};
		
		//개인정보 보호를 위해서 마지막 4자리를 제외한 나머지는 * 처리하세요
		// 01033334444 -> *******4444
		// 027778888 -> *****8888
		/*
		for (String str : numbers) {
			Matcher m = Pattern.compile("\\d+(?=\\d{4}$)").matcher(str);
			while (m.find()) {
				System.out.println(m.group());
				str = str.replaceAll("\\d+(?=\\d{4}$)", "*".repeat(m.group().length()));
				System.out.println(str);
			}
		}
		*/
		for (String num : numbers) {
			// "\\d(?=\\d{4})" <- 숫자 대상
			// ".(?=.{4})" <- 임의의 문자 대상
			
			Matcher m = Pattern.compile("\\d(?=\\d{4})").matcher(num);
			
			while (m.find()) {
				System.out.print(m.group()+", ");
			}
			System.out.println();
			
			String answer = num.replaceAll(".(?=.{4})", "*");
			System.out.println(answer);
		}
		
	}

}
