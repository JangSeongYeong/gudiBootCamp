package chap11.ex08;

public class WorkObj {

	// notify(), notifyAll(), wait() 을 사용할 떄는 syncronized 안에서 해야 한다.
	// 깨우고 자려고할때 깨우면 안되니까
	public synchronized void work() {
		System.out.println(Thread.currentThread().getName()+"가 실행 됨");
		notify(); // 다른 누구를 꺠우고
		try {
			wait(); // 스스로 잔다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
