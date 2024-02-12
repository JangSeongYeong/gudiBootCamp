package chap12.ex02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {

		ServerSocket server = null; // 선언을 코드 블럭 안에서 하면 scope 로 인해 try 에서 나갈경우 사라짐
		try {
			// 1. 서버 소켓 생성 : 어디로 들어올건지 호실(포트) 지정
			server = new ServerSocket(5600);
			// 2. 요청 대기
			while (true) {
				System.out.println("접속 요청 대기 중...");
				Socket socket = server.accept(); // 3. 접속 요청이 올 경우 수락 (소켓 안에는 접속 요청자의 모든 정보가 있다.)
				// 4. 클라이언트가 요청할 일이 있으면 처리
				// 요청한 클라이언트의 아이피와 포트 알아보기
				InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("접속 완료 : "+addr.getAddress()+" : "+addr.getPort());
			}		
		} catch (IOException e) {
			e.printStackTrace();
			try {
				server.close();				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// 종료할때, ㅁ를 눌러서 끄고 우클릭한 뒤 Terminate/Disconnect All 을 눌러 한번 더 종료
	}

}
