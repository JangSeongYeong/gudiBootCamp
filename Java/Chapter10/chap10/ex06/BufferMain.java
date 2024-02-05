package chap10.ex06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferMain {
	
	// 이미지 복사하기
	public static void main(String[] args) throws Exception {
		
		// 1-1. 파일 읽어올 빨대 준비 // 읽어올 위치 + 파일 객체 + 읽어올 스트림
		FileInputStream fis = new FileInputStream("C:/img/high.mp4");		
		// 1-2. 나갈 빨대 준비 // 내보낼 위치 + 파일 객체 + 내보낼 스트림
		FileOutputStream fos = new FileOutputStream("C:/img/temp/high_copy.mp4");
		
		// 보조 스트림 준비
		BufferedInputStream bis = new BufferedInputStream(fis); // FileInputStream 탑승
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// 시간측정용 변수
		long start = 0;
		long end = 0;
		
		// 2. 읽어오기+쓰기
		int data;
		start = System.currentTimeMillis();
		while ((data = bis.read()) != -1) {
			bos.write(data);
			// syso 를 사용하면 버퍼메모리 활용도가 매우 낮아진다.
		}
		System.out.println("복사 끝");
		end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start)+" ms");
		
		// 3. 열어둔 자원 반납 (flush, close)
		bis.close();
		bos.flush();
		bos.close();
	}

}
