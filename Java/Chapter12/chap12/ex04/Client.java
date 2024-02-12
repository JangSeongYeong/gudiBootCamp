package chap12.ex04;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;
		
		try {
			// 통신 소켓 생성
			socket = new Socket("localhost", 7777); // local host 를 다른 IP 로 바꿔주면 동일 대역폭 다른 컴퓨터로 전송가능
			System.out.println("연결 성공");
			
			// scannner 선언
			Scanner scan = new Scanner(System.in);
			
			// 주 스트림, 보조스트림
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			// 스캐너로 입력
			System.out.print("전송할 내용 > ");
			String msg = scan.nextLine();
			
			// 쓰기
			oos.writeUTF(msg);
			System.out.println("보낸 메시지 : "+msg);
			oos.flush();

			// 자원 반납 
			oos.close();
			scan.close();
			socket.close();
		
		} catch (Exception e) {
			// 연결 실패시 자원 반납
			try {
				System.out.println("연결실패");
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		
		
		
	}

}
