package chap11.ex09;

public class Inter extends Thread {

	@Override
	public void run() {
		/*
		// Interrupt Exception 을 강제로 일으켜 정지 시키는 방법
		try {
			while (true) {
				System.out.println("Inter thread 실행중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			// 자원정리 하는 부분을 catch 부분에 넣어서
			System.out.println("자원 정리");
			System.out.println("정상 종료");
		}
		*/
		
		while (true) {
			System.out.println("Inter thread 실행중...");
			if (Thread.interrupted()) { // interrupt 걸렸니??
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("정상 종료");
	

	}
	
}
