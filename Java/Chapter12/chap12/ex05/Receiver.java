package chap12.ex05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver { // Server

	public static void main(String[] args) {

		ServerSocket server = null;
		
		try {
			// 서버 소켓 생성
			server = new ServerSocket(9876);

			while (true) { // 바로 종료가 되지 않게 하기 위해
				// 접속 대기
				System.out.println("접속 대기중...");
				// 클라이언트 연결
				Socket socket = server.accept();
				System.out.println("접속 완료");
				
				// 클라이언트로 보낸 스트림 추출
				InputStream is = socket.getInputStream();
				BufferedInputStream bis = new BufferedInputStream(is);				
				ObjectInputStream ois = new ObjectInputStream(bis);
				
				String fileName = ois.readUTF();
				
				// 내 PC의 특정 경로로 저장
				FileOutputStream fos = new FileOutputStream("C:/Users/zxz06/Downloads/"+fileName);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				System.out.println("파일 저장 시작");
				int data;
				while ((data = ois.read()) != -1) { // 받는 입장에서는 어떤 크기가 오는지 모르기에 이 형태로 만든다.
					bos.write(data);
				}
				System.out.println("파일 저장 완료");
				
				// 자원정리
				bos.flush();
				ois.close();
				bos.close();
				socket.close();
			}
			
		} catch (IOException e) {
			// 접속 불가시 소켓 정리
			try {
				server.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
