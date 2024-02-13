package chap12.ex07;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

	public static void main(String[] args) throws IOException {
		
		// 1. 스레드 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		// 2. 서버 소켓 생성
		ServerSocket server = new ServerSocket(8080);
		
		// 3. 접속 대기 + 접속 수락
		while (true) {
			System.out.println("접속 대기중...");
			Socket socket = server.accept();
			System.out.println("접속 수락");
			
			// 스레드에게 브라우저가 보낸 내용을 받도록 할 예정
			Runnable run = new Runnable() {
				
				@Override
				public void run() {
					// 소켓으로부터 클라이언트가 보내온 메시지 받기
					try {
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						// 65536 : http protocol 에 의해서 받을 수 있는 최대 byte 수
						byte[] buf	= new byte[65536];
						dis.read(buf);
						// 받아온 byte 를 문자열 화 해서 출력
						String request = new String(buf);
						System.out.println(request);
						
						// 요청에 대한 응답 (응답이 없으면 대답할 때까지 클라이언트(브라우저)는 대기한다.) : 동기 방식
						// PrintStream : 뭔가를 직접 기록하는 보조스트림
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						// 헤더(머릿말)
						ps.print("HTTP/1.1 200 \r\n"); // HTTP 1.1버전으로 통신할거야, 통신은 정상이야(200)
						ps.print("Content-type: text/html \r\n"); // 지금부터 응답할 컨텐츠는 html 과 text 로 구성되어 있어
						
						ps.print("\r\n"); // new line - 줄 바꿈의 의미 : 공백 이후는 바디
						// 바디(본문)
						String msg = "<h3>Success Receive</h3>";
						ps.print(msg);
						ps.flush();
						// 자원반납
						dis.close();
						ps.close();
						socket.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			};
			// 풀한테 스레드를 빌려달라고 요청
			pool.execute(run);
			
		}
		
		
	}

}
