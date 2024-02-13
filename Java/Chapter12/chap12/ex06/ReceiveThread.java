package chap12.ex06;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

// 받기 전용 스레드
public class ReceiveThread extends Thread {

	Socket socket = null;
	ObjectInputStream ois = null;
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			ois = new ObjectInputStream(socket.getInputStream()); // 스트림 받아냄
			while (true) {
				String msg = ois.readUTF();
				System.out.println("상대> "+msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				ois.close();
				socket.close();				
			} catch (Exception e1) {}
		}
		
	}

		
	
}
