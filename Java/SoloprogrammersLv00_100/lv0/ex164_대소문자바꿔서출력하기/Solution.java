package lv0.ex164_대소문자바꿔서출력하기;

import java.util.Scanner;

public class Solution {
	/* 영어 알파벳으로 이루어진 문자열 str이 주어집니다. 
	 * 각 알파벳을 대문자는 소문자로 소문자는 대문자로 변환해서 출력하는 코드를 작성해 보세요.*/
    
	// 입력 aBcDeFg
	// 출력 AbCdEfG
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuffer buffer = new StringBuffer();
        
        for (int i = 0; i < a.length(); i++) {
        	char c = a.charAt(i);
			if (Character.isUpperCase(c)) {
				buffer.append(Character.toLowerCase(c));
			} else {
				buffer.append(Character.toUpperCase(c));
			}
		}
        System.out.print(buffer.toString());
        sc.close();
    }
}