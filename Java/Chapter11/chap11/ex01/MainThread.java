package chap11.ex01;

public class MainThread {

	public static void main(String[] args) throws Exception { 
		// main 메서드는 main thread 를 동작하게 해주는 메서드

		// 워크 스레드를 호출(객체화)
		WorkThread job = new WorkThread();
		Thread th = new Thread(job); // 워크 스레드 생성
		th.start(); // 워크 스레드가 실행 됨
		
		// 이 안의 움직임은 모두 메인 스레드의 움직임이었음
		for (int i = 0; i < 5; i++) {
			System.out.println("메인 스레드가 하는 일 - "+i);
			Thread.sleep(500); // Thread 한테 0.5초씩 자라고 한다. ms 단위 (멈추라고)
		}
		
	}

}
