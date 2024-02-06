package chap10.ex10;

import java.io.FileInputStream;
import java.util.Properties;

public class PropInput {

	public static void main(String[] args) throws Exception{
		// 주로 사용은 properties 내용을 수정하여 자기가 사용하기에 맞게 하는 것을 할것임 직접 불러오는 읽은 거의 없을 것임 

		// 1. 스트림 준비
		FileInputStream fis = new FileInputStream("src/chap10/ex10/profile.properties");
		
		// 2. Properties 불러오기
		Properties prop = new Properties();
		prop.load(fis); // 스트림으로 읽어온 값이 Properties 에 저장 
		
		// 3. 읽기
		for (Object key : prop.keySet()) { //prop 은 정해주지 않아서 Object 이다.
			System.out.println(key+" : "+prop.get(key));
		}
		
		// 4. 자원반납
		fis.close();
		
	}

}
