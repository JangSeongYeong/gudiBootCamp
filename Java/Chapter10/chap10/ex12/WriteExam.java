package chap10.ex12;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class WriteExam {

	public static void main(String[] args) throws Exception {
		// JAVA IO 방식으로 입력받은 내용 파일로 저장하기
		// 1. Scanner 준비
		// 2. 입력받은 내용 변수에 저장
		// 3. 스트림 준비
		// 4. 쓰기
		// 5. 자원반납
		
		// JAVA NIO 방식으로 입력받은 내용 파일로 저장하기
		// 1. Scanner 준비
		Scanner scan = new Scanner(System.in);
		// 2. 입력받은 내용 변수에 저장
		System.err.print("입력 > ");
		String msg = scan.nextLine() + "\r\n";
		// 4. 쓰기
		Path path = Paths.get("C:/img/nio/input.txt");
		
		// 없으면 자동으로 만들어주지 않아서 위에 파일 추가 코드 삽입
		if(Files.notExists(path)) {
			Files.createFile(path);
		}
		
		//Files.writeString(path, msg, StandardOpenOption.APPEND);
		Files.write(path, msg.getBytes("UTF-8"), StandardOpenOption.APPEND);
		/* APPEND : 같은 파일이 있을 경우 이후에 내용을 추가
		 * CREATE : 파일이 존재하지 않으면 파일 생성
		 * CRATE_NEW : 이미 파일이 존재할 경우 새 파일을 생성 (덮어쓰기 X)
		 * READ : 읽기 전용
		 */
		
		// 5. 자원반납
		scan.close();
		System.out.println("저장 완료");
	}

}
