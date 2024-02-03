package chap08.ex02;

public class StringUtils {

	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String strResult;
		boolean boolResult;
		
		/*문자열 비교*/
		boolResult = "abcdefg".equals(str);
		System.out.println("두 문자가 같은가? " +boolResult);
		
		/*특정 문자열 포함 여부*/
		boolResult = str.contains("c");
		System.out.println(str+" 안에 c가 포함되어있는가? " + boolResult);
		
		/*문자열 교체*/  //charSequence라고 적혀져있으면 문자열이라고 생각,  regex -> 정규표현식
		strResult = str.replace("abc", "abc".toUpperCase());
		System.out.println(str + " => " + strResult);
		
		/*앞뒤 공백 제거*/
		str = " 가나다라마바사 ";
		strResult = str.trim();
		System.out.println(str);
		System.out.println(strResult);
		
		/*문자열의 시작과 끝*/
		str = "[img]uploadFile.png";
		
		// [img] 로 시작하는가?(start)   toffset : 문자열에서 어디서부터 시작할건지
		boolResult = str.startsWith("[img]");
		System.out.println("[img]로 시작하는가? "+boolResult);
		
		// .png 로 끝나는가?(end);
		boolResult = str.endsWith(".png");
		System.out.println(".png로 끝나는가? "+boolResult);
		
		/*반복 repeat*/
 		strResult = "*".repeat(6);
 		System.out.println(strResult);
	}

}
