package chap10.ex03;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;

public class InputMain {

	public static void main(String[] args) throws Exception {
		// 1. 읽어올 파일 위치 설정
		String path = "C:/img/temp/test.txt";
		
		// 2. 파일 객체화
		File file = new File(path);
		// File file = new File("C:/img/temp/test.txt"); 도 가능
		
		// 3. 읽어들일 빨대(InputStream) 준비
		FileReader reader = new FileReader(file, Charset.forName("UTF-8"));
		
		// 4. 읽어와서 출력
		// 아스키코드로 읽어온다.
		// 그리고 더이상 읽을 내용이 없다면 -1 반환(EOF : End of File -> 모든 언어 공통임)
		int data;
		
		while ((data=reader.read())!= -1) { // .read 를 통해 읽어오는 값 -> ASCII CODE
			System.out.print((char)data); // char 를 통해 변환
		}
		
		// 5. 다쓴 빨대(InputStream) 반납
		reader.close();
		
	}

}
