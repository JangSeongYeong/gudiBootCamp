package chap10.ex04;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) throws Exception {
		/*
		// 1-1. 읽어올 위치 + 파일 객체
		File src = new File("C:/img/low.jpg");
		// 1-2. 내보낼 위치 + 파일 객체
		File dst = new File("C:/img/temp/low_copy.jpg");
		*/
		
		// 2-1. 읽어올 빨대 준비(File 이 앞에 붙으면 파일 객체가 내장 되었다.) - 그러므로 파일객체 안만들어도 됨
		FileInputStream fis = new FileInputStream("C:/img/high.jpg");
		// 2-2. 내보낼 빨대 준비
		FileOutputStream fos = new FileOutputStream("C:/img/temp/high_copy.jpg");

		
		int i = 0;
		/*
		// 3. 읽어오기 -> 쓰기 (안정성이 훨씬 낫다. 하지만 속도가 느리다.)
		int data;
		
		while ((data = fis.read()) != -1) {
			fos.write(data);
			i++; // 별 의미 없이 성능 체크 용도
			System.out.println("파일 복사중..."+i);
		}
		*/
		
		// 담기는 컵(배열이냐 변수이냐)에 따라서 속도 차이가 확연히 차이가 난다.
		byte[] arr = new byte[1024]; // 컵은 data 에서 배열로 체인지
		while (fis.read(arr) != -1) { // 배열을 넣으며 얼마나 옮기는지 출력, 이후 더 이상 잃을게 없으면 -1 반환
			// 읽은 데이터는 매개변수로 주어진 배열에 담긴다.
			fos.write(arr);
			i++; // 별 의미 없이 성능 체크 용도
			System.out.println("파일 복사중..."+i);
		}
		
		// 4. 자원 반납(flush, close)
		fis.close();
		fos.flush();
		fos.close();
	}
	
}
