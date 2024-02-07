package chap11.ex10;

public class DemonThread extends Thread {

	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(500);
				System.out.println("(워크/데몬) 스레드 동작 중...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
