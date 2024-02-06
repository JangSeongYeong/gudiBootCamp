package chap11.ex02;

public class Main {

	public static void main(String[] args) {
		
		Thread th = new Job(); // 스레드 객체화 (Job 은 Thread 를 상속 받았기에 다형성을 통해서 들어갈 수 있다)
		// 스레드 실행
		th.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
