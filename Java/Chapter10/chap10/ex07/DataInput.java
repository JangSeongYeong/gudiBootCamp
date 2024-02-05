package chap10.ex07;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class DataInput {

	public static void main(String[] args) throws Exception {
		// 1. 읽어올 파일의 위치 + 파일 객체 생성 + 주 스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/temp/input_sample.dat");
		
		// 2. 보조 스트림 준비 (java 고유 데이터 사용 + 속도 UP(필수 아님))
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		// 3. 읽어오기 - 쓴 순서 그래도 읽어와야 한다.
		String name = dis.readUTF();
		int salary = dis.readInt();
		boolean promotion = dis.readBoolean();
		
		System.out.println(name+"/"+salary+"/"+promotion);
		// 4. 자원 반납 (close)
		dis.close();
	}

}
