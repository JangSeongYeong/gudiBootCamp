package lv0.ex156_a와b출력하기;

import java.util.Scanner;

public class Solution {
	/*정수 a 와 b 가 주어집니다. 
	 * 각 수를 입력받아 입출력 예와 같은 형식으로 출력하는 코드를 작성해 보세요.*/
    
	/*4 5*/
	/* a = 4
		b = 5*/
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        
        sc.close();
    }
}