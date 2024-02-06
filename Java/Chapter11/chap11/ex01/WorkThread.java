package chap11.ex01;

public class WorkThread implements Runnable {

	@Override
	public void run() { // 스레드가 해야할 일을 여기에 적는다.
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("워크 스레드가 하는 일 - "+i);
				Thread.sleep(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
