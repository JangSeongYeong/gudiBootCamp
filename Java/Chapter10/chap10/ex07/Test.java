package chap10.ex07;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception {
		// 이름, 급여 승진 여부를 직접 입력 받아 저장해보기
		// input_sample.dat로 저장
		
		// 1. 데이터를 입력 받을 scanner 객체
		Scanner scan = new Scanner(System.in);
		
		// 2. 내보낼 위치 + 파일 객체 + 주 스트림
		/* 이어쓰기를 하고 싶다면 여기서 수정 */
		FileOutputStream fos = new FileOutputStream("C:/img/temp/input_sample.dat"); 
		
		// 3. 보조 스트림 준비 (Java 고유 데이터 타입으로 내보내기)
		DataOutputStream dos = new DataOutputStream(fos);
		
		// 4. scanner 로 데이터 입력 받기
		System.out.print("이름을 입력하세요 : ");
		String name = scan.nextLine();
		
		System.out.print("급여을 입력하세요 : ");
		int salary = scan.nextInt();
		
		System.out.print("승진여부를 입력하세요 : ");
		boolean promotion = scan.nextBoolean();

		System.out.println(name+" / "+salary+" / "+promotion+" 이 입력되었습니다.");
		
		// 5. 내보내기
		dos.writeUTF(name);
		dos.writeInt(salary);
		dos.writeBoolean(promotion);
		
		// 6. 자원 반납
		scan.close();
		dos.flush();
		dos.close();
	}

}
