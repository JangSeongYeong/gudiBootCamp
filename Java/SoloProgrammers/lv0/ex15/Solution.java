package lv0.ex15;

import java.util.Scanner;

public class Solution {
	/*두 개의 문자열 str1, str2가 공백으로 구분되어 입력으로 주어집니다.
	입출력 예와 같이 str1과 str2을 이어서 출력하는 코드를 작성해 보세요.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
       
        a.trim();
        b.trim();
        
        System.out.println(a+b);
        
        sc.close();
    }
}
