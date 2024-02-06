package chap10.ex09;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Map;

public class ObjectInputMain {

	public static void main(String[] args) throws Exception {

		// 1. 경로 및 주 스트림 준비
		FileInputStream fis = new FileInputStream("C:/img/object.dat");
		
		// 2. 보조스트림 준비(속도향상:버퍼, 오브젝트)
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		// 3. 읽기
		// map - Map 이 HashMap 의 부모이기에 다형성 적용
		Map<String, String> map = (Map<String, String>) ois.readObject();
		// array
		int[] arr = (int[]) ois.readObject();
		// String
		String str = ois.readUTF();
		// class
		Sample sample = (Sample) ois.readObject();
		
		System.out.println(map);
		System.out.println(Arrays.toString(arr));
		System.out.println(str);
		System.out.println(sample.team+" "+sample.num+" "+sample.job);
		System.out.println(sample.method());
		
		// 4. 자원 반납
		ois.close();
	}

}
