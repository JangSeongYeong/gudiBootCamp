package chap11.ex01;

public class AnonyMain {

	public static void main(String[] args) {
		
		// Runnable 인터페이스로 할일 생성
		Runnable job = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("work thread...");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		// Thread 객체화시 인터페이스 대입
		Thread th = new Thread(job);
		th.start();	// 실행
		
		// MainThread
		for (int i = 0; i<5; i++) {
			System.out.println("main thread...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
