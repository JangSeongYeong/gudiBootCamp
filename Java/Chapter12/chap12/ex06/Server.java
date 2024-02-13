package chap12.ex06;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// 1. 서버 소켓 생성
		ServerSocket server = new ServerSocket(8080);
		
		// 2. 접속 확인
		System.out.println("연결 대기중,,,");
		Socket socket = server.accept();
		System.out.println("연결 성공");
		
		// 3. 보내기
		SenderThread sender = new SenderThread(socket);
		sender.start();
		
		// 4. 받기
		ReceiveThread receive = new ReceiveThread(socket);
		receive.start();
							
	}

}
