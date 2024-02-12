package chap12.ex05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Sender { // Client

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {
			// 소켓생성 (서버 연결)
			socket = new Socket("localhost", 9876);
			System.out.println("접속 완료");
			
			// 내 PC 에서 파일 불러오기
			File file = new File("C:/img/high.mp4"); // 파일 객체
			String fileName = file.getName(); // 파일 이름
			long size = file.length(); // 크기 (byte)
			
			// 파일 스트림 추출 (받아오는 stream)
			FileInputStream fis = new FileInputStream(file);			
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			// 내 PC에서 읽어온 내용 소켓으로 내보내기 (보내는용 스트림)
			OutputStream os = socket.getOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(os);
			ObjectOutputStream oos = new ObjectOutputStream(bos); // 바이트 스트림은 기본 타입 데이터를 보낼수 없다.
			
			oos.writeUTF(fileName); // 파일명 전송
			byte[] arr = new byte[(int) size];
			int data = bis.read(arr); // 배열에 데이터가 담기고, 읽은 바이트 수 반환
			System.out.println("한번에 읽은 크기 : "+data);
			
			oos.write(arr);
			System.out.println("전송 완료 : 크기("+(size/1024)+"KB)");
			
			
			/*
			System.out.println("파일 전송 시작");
			int data;
			while ((data = bis.read()) != -1) {
				bos.write(data); 
			}
			System.out.println("파일 전송 완료");
			*/
	
			// 자원정리
			oos.flush();
			oos.close();
			bis.close();
			bos.close();
			socket.close();
			
		} catch (Exception e) {
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
