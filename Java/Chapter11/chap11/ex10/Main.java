package chap11.ex10;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// 워크 스레드는 메인스레드가 끝나도 계속 움직인다.
		Thread thread = new DemonThread();
		// 데몬 스레드로 설정하면 메인 스레드와 함께 끝난다.
		thread.setDaemon(true); // 데몬 스레드 지정
		thread.start();
		
		Thread.sleep(3000);
		
		System.out.println("메인 스레드 종료");
		
	}

}
