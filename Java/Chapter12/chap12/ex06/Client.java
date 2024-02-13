package chap12.ex06;

import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// 소켓 생성
		Socket socket = null;
		
		try {
			// 1. 서버와 연결
			socket = new Socket("localhost", 8080);
			System.out.println("연결 성공");
			
			// 2. 보내기
			SenderThread sender = new SenderThread(socket);
			sender.start();
			
			// 3. 받기
			ReceiveThread receive = new ReceiveThread(socket);
			receive.start();
			
			
		} catch (Exception e) {
			System.out.println("연결 실패");
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
	}

}
