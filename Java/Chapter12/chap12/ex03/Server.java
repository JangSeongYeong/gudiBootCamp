package chap12.ex03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {
		// try 안에서 선언시 블럭 밖을 못나가기에 제어를 위해서 선언은 위에서
		// Address already in use 에러 -> 이미 포트에서 사용중
		ServerSocket server = null;
		
		try {
			// 1. 서버 소켓 생성 : 포트 지정
			server = new ServerSocket(5500);			
			while (true) {
				// 2. 요청 대기
				System.out.println("접속 요청 대기중");
				
				// 3. 접속 요청이 올 경우 수락
				Socket socket = server.accept(); //blocking
				System.out.println("접속 성공");
				
				// 4. 클라이언트가 요청할 일이 있으면 처리
				// 4-1 주스트림 준비
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				// 4-2 보조스트림 준비
				ObjectInputStream ois = new ObjectInputStream(is);
				ObjectOutputStream oos = new ObjectOutputStream(os);
				// 4-3 읽기
				String msg = ois.readUTF();
				System.out.println("Client> "+msg);

				// 4-4 쓰기
				oos.writeUTF("니가 보낸 메시지 : "+msg);
				
				// 4-5 다썼으면 자원 반납
				oos.flush();
				ois.close();
				oos.close();
			
				socket.close();
			}
		} catch (IOException e) {
			// 예외 발생시 자원반납
			System.out.println("접속 실패");
			e.printStackTrace();
			try {
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}		
	}

}
