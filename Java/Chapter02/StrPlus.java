
public class StrPlus {

	public static void main(String[] args) {
		// 문자가 '발견되는 시점'부터는 더하기(plus)가 아닌 추가(add)가 된다. 즉, 발견전까지는 더하기
		String str1 = "JDK"+8+0.65;
		System.out.println(str1); // JDK80.65
		
		String str2 = 8+0.65+"JDK";
		System.out.println(str2); // 8.65JDK
	
		String str3 = "8"+0.65+"JDK";
		System.out.println(str3); // 80.65JDK
		// String str3 = ""+8+0.65+"JDK";
		
	}

}
