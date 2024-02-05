package chap10.ex05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class test {

	public static void main(String[] args) throws IOException {
		
		// Scanner 로 입력 받은 내용을 sample.txt 파일에 저장
		// 입력된 내용은 계속 추가 되어야 합니다.
		
		// 1. 내보낼 파일 위치 설정
		File file = new File("C:/img/temp/sample.txt");
		if (file.exists() == false) { // 파일이 없으면 생성
			file.createNewFile();
		}
		
		// 2-2. 시스템에서 내용을 불러올 Scanner 준비
		Scanner scan = new Scanner(System.in);
		
		// 2-2. 스케너로 입력
		System.out.print("내용 입력> "); // 입력창 표시 (ln 의 생략으로 줄바꿈 없음)
		String inputStr = scan.nextLine(); // 입력 후 변수에 저장
		
		// 3. 파일로 내보낼 FileWriter 준비
		FileWriter writer = new FileWriter(file, true);
		
		// 4. Scanner 로 읽어온 내용을 파일로 내보낸다.
		writer.write(inputStr+"\r\n"); // 입력한 내용을 파일로 내보낸다.
		System.out.println(inputStr+"를 입력했습니다."); // 입력 완료 메시지
		
		// 5. 사용한 자원을 닫는다.
		scan.close();
		writer.flush();
		writer.close();
		
	}

}
