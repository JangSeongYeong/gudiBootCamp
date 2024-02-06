package chap10.ex09;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class ObjectOutputMain {

	public static void main(String[] args) {
		
		// 1. 주 스트림 준비
		try {
			FileOutputStream fos = new FileOutputStream("c:/img/object.dat");
			// 2. 보조스트림 준비 (속도 + 오브젝트 내보내기) - 파일 전송이 아닐때 버퍼를 사용하는 것은 낭비이다.
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			// 3. 내보내기
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "장성영");
			map.put("phone", "010-1234-5678");
			// map 형태 넣기
			oos.writeObject(map);
			
			// array 형태 넣기
			oos.writeObject(new int[] {10,20,30,40,50});
			
			// 기본 형태 넣기
			oos.writeUTF("기본 형태도 사용 가능");
			
			// 클래스 객체 넣기
			oos.writeObject(new Sample());
			
			// -> ObjectOutput은 모든 것을 넣을 수 있기에 DataOutput을 잘 사용하지 않는다.
			// 단! 다른 언어와 통신할떄에는 Object 는 자바용이기에 호환이 안된다.
			
			// 4. 자원 반납
			oos.flush();
			oos.close();
			System.out.println("저장 완료");
		} catch (Exception e) {
			System.out.println("파일 저장중 문제 발생");
			e.printStackTrace();
		}
			
		
	}

}
