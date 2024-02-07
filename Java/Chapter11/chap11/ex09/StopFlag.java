package chap11.ex09;

public class StopFlag extends Thread {
	
	private boolean stop = false;

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while (!stop) {
			System.out.println("stop flag thread 실행 중...");
		}
		System.out.println("자원 정리 등의 뒷정리");
		System.out.println("정상 종료");
	}
	
	
}
