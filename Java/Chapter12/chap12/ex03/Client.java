package chap12.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		
		try {
			// 1. 소켓 생성 (IP,Port) -> 서버한테 접속 요청한거
			socket = new Socket("localhost", 5500);
			
			// 2. 예외가 발생하지 않으면 접속 완료
			System.out.println("접속 성공");
			
			// 할일있으면 처리
			String msg = "Time 2024-02-08, 11:22 AM";
			
			// 주스트림
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			
			// 보조스트림
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(is);
			
			// 쓰기
			System.out.println("전송 내용 : "+msg);
			oos.writeUTF(msg);
			oos.flush(); // 쓰고 나서 flush 필수
			
			// 읽기
			msg = ois.readUTF();
			System.out.println(msg);
			
			// 자원반납
			oos.close();
			ois.close();
			
		} catch (Exception e) {
			// 3. 예외 발생시 접속 거절
			System.out.println("접속 실패");
			e.printStackTrace();
		} finally {
			try {
				// 3. 자원 반납
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}

}
