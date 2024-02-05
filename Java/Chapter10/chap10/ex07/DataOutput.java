package chap10.ex07;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutput {
	
	// java 의 고유 데이터를 저장하기 위해서는 dat 확장자를 사용해야 한다.
	public static void main(String[] args) throws Exception {
		
		// 1. 내보낼 파일 경로 지정 | 내보낼 위치 + 파일객체 + 주 스트림 준비
		// 2. 내보내기에 필요한 Stream(빨대) 선택 | 위에 주 스트림
		FileOutputStream fos = new FileOutputStream("C:/img/temp/data.dat");
		
		// + 보조 스트림 준비 (속도 UP + Java 고유 데이터 타입 저장)
		BufferedOutputStream bos = new BufferedOutputStream(fos); // fos 탑승
		DataOutputStream dos = new DataOutputStream(bos);  // bos 탑승
		
		// 3. 내보내기 작업 | 내보내기
		dos.writeUTF("장성영");
		dos.writeInt(9000000);
		dos.writeBoolean(false);
		
		// 4. 자원 닫아주기 | flush, close
		dos.flush();
		dos.close();
		
	}

}
