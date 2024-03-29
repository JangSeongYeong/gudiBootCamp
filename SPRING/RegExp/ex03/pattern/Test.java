package ex03.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// 다음 중 문자가 섞인 값의 인덱스를 찾으시오
		String[] test1 = {"123", "1d2", "456", "ddd4", "132.456", "3@2"};
		for (int i = 0; i < test1.length; i++) {
			Matcher m = Pattern.compile("[^\\d]").matcher(test1[i]);
			if(m.find()) System.out.println(i+" : "+test1[i]+"  "+m.group());
		}
		
		System.out.println();
		
		// 다음 중 특수문자가 사용된 값의 인덱스를 찾으시오
		String[] test2 = {"tester", "test!!", "master.id", "master.id", "main_id"};
		for (int i = 0; i < test2.length; i++) {
			Pattern p = Pattern.compile("[^\\w]");
			Matcher m = p.matcher(test2[i]);
			if (m.find()) System.out.println(i+" : "+test2[i]+"  "+m.group());
		}
	}

}
