package chap08.ex02;

import java.util.Arrays;

public class StringArr {

	public static void main(String[] args) { // 문자열 == 문자 배열
		
		String str = "abcedfg";
		
		String strResult;
		int intResult;
		char chResult;
		
		// 문자열의 길이
		intResult = str.length();
		System.out.println(str+"문자열의 길이는 " +intResult);
		
		// 특정 인덱스의 값 가져오기
		chResult = str.charAt(2);
		System.out.println(str+"의 2번 index 의 문자는" +chResult);
		
		// 문자열 -> 캐릭터 배열
		char[] arr = str.toCharArray();
		System.out.println(arr[2]);
		
		// 특정 문자가 어느 인덱스에 있는지 확인
		str = "abcdabcdabcd";
		
		// a 를 찾아보자(1개 밖에 못찾음 - 앞에서부터 찾음)
		intResult = str.indexOf("a");
		System.out.println("a의 위치는 : "+intResult);
		
		// 이번에는 뒤에서부터 찾는다.(1개 찾는건 동일)
		intResult = str.lastIndexOf("a");
		System.out.println("a의 위치는 : "+intResult);
		
		// 모든 c 를 다 찾고 싶다면?    --> 배열에 넣고 한번에 출력하려고 한 똥꼬쇼
		int[] indexArr = new int[5];
		int index = 0;
		indexArr[index] = str.indexOf("c");
		int lastResult = str.lastIndexOf("c");
		
		while (indexArr[index] != lastResult) {
			indexArr[index+1] = str.indexOf("c", indexArr[index]+1);
			index++;
		}
		System.out.println(Arrays.toString(indexArr));
		// 이렇게 할 경우에 동일한 문자갯수 파악을 하는 메서드를 만들어주지 않으면 더 길어짐 아래 코드를 하는게 더 합리적
		
		// 모든 c 를 다 찾고 싶다면?
		// 1. 배열 활용
		arr = str.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'c') {
				System.out.println("c 의 위치 : "+i);
			}
		}
		
		// 2. indexOf 오버로드 메서드 활용(코드리뷰)
		intResult = 0;
		
		while(intResult > -1) { // -1 은 없댜는 뜻
			intResult = str.indexOf("c", intResult);
			// 1번째 방법
			if(intResult == -1) {
				break;
			}
			System.out.println("c의 위치 : "+intResult);
			intResult++;
			
			// 2번째 방법
//			if(intResult > -1) {
//				System.out.println("c 의 위치 : "+intResult);
//				intResult++;
//			}
		}	
		
		// 문자열 잘라내기 (beginIndex : 몇번부터 볼거야, ednIndex : 몇번부터 안볼거야)
		str = "0123456789";
		strResult = str.substring(3); // 3번 인덱스부터 끝까지
		System.out.println(strResult);
		
		strResult = str.substring(1, 5); // 1번 인덱스부터 보여주고, 5번 인덱스부터 버려
		System.out.println(strResult);
		
		// 특장 문자를 기준으로 잘라내기
		str = "a/b/c/d/e/f/g";
		String[] list = str.split("/");
		System.out.println(Arrays.toString(list));
		
		list  = str.split(""); // 구분자를 안 넣으면 어떻게 되는가? -> 한자 한자 다 끊어 놓는다.
		System.out.println(Arrays.toString(list));
		
	}

}
