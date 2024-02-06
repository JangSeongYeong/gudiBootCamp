package chap10.ex10;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropOutput {

	public static void main(String[] args) throws Exception {
		
		// 1. properties 객체에 데이터 저장 (한글 금지)
		Properties prop = new Properties();
		prop.put("id", "admim");
		prop.put("pass", "1234");
		prop.put("name", "Jang,Seong-yeong");
		prop.put("email", "zxz0608@email.com");
		
		// 2. 주스트림 준비 + 보조스트림(선택)
		FileOutputStream fos = new FileOutputStream("src/chap10/ex10/profile.properties");
		
		// 3. 저장
		prop.store(fos, "simple comment"); // 내보낼 스트림, 주석
		
		// 4. 자원 반납 (flush, close)
		// Properties 를 사용하게 되면 flush 를 하지 않아도 된다 알아서 해줌(선택사항)
		fos.close();
	}

}
