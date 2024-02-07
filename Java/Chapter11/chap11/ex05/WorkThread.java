package chap11.ex05;

public class WorkThread extends Thread {

	@Override
	public void run() {
		// 실행 -> 1.5초 휴식 -> 실행 -> 종료
		long cnt = 0;
		
		for (int i = 0; i < 100000000; i++) {
			cnt++;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		cnt = 0;
		for (int i = 0; i < 100000000; i++) {
			cnt++;
		}
		
	}
	
}
