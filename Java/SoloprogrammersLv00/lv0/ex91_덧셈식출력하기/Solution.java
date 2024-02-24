package lv0.ex91_덧셈식출력하기;

import java.util.Scanner;

public class Solution {
	/*두 정수 a, b가 주어질 때 다음과 같은 형태의 계산식을 출력하는 코드를 작성해 보세요.*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(a + " + "+ b +" = "+(a+b));
        
        sc.close();
    }
}