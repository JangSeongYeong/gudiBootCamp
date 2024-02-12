package chap12.ex04;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket server = null;
		
		try {
			// 서버 소켓 생성
			server = new ServerSocket(7777);
			
			while (true) {
				System.out.println("접속 대기중...");
				// 접속 수락
				Socket socket = server.accept();
				System.out.println("접속 성공");
				
				// 받기 (스트림 사용)
				// 주스트림
				InputStream is = socket.getInputStream();
				// 보조스트림
				ObjectInputStream ois = new ObjectInputStream(is);
				
				// 받은 내용 출력
				String msg = ois.readUTF();
				System.out.println("받은 내용 : "+msg);
				
				// 자원 반납
				ois.close();
				socket.close();
			}
			
		} catch (IOException e) {
			// 소켓 생성 에러 발생시 자원 반납
			try {
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
		
	}

}
