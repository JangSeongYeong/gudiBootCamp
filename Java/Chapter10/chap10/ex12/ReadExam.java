package chap10.ex12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadExam {

	public static void main(String[] args) throws IOException {
		// java IO
		// 1. 위치 지정 + 주 스트림 준비		
		// 2. 보조스트림 생성
		// 3. 읽기
		// 4. 자원반납
		
		// JAVA NIO 파일 내용 출력하기
		// 1. 위치 지정
		Path path = Paths.get("C:/img/temp/test.txt");
		// 2. 읽기
		// readByte 는 일반 파일, readLine 은 텍스트
		List<String> lines = Files.readAllLines(path);
		// 자원 반납 없음
		for (String str : lines) {
			System.out.println(str);
		}
		
	}

}
