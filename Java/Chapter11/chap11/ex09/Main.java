package chap11.ex09;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		// stop() 메서드를 사용하면 자원정리 및 뒷정리를 할 시간도 없이 꺼지게 된다.
		
		/*
		// stop flag 를 활용한 스레드 정지
		// stop flag 의 정지전에 자원정리 및 뒷정리를 하는 것이 중요하다. (그냥 꺼지는 것이 아니라)
		StopFlag stop = new StopFlag();
		stop.start();
		Thread.sleep(1000);
		stop.setStop(true);
		*/
		
		/* interrupt 발생으로 스레드 정지 */
		Inter inter = new Inter();
		inter.start();
		Thread.sleep(1000);
		inter.interrupt(); // 강제 인터럽트 발생
		
		
		
	}

}
