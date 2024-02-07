package chap11.ex06;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		WorkThread thA = new WorkThread();
		thA.setName("thread A");
		WorkThread thB = new WorkThread();
		thB.setName("thread B");
		thA.start();
		thB.start();
		
		thA.yield = true; // thA 한테 양보 하라고 함
		Thread.sleep(500); // 0.5 초 후에 
		
		thA.yield = false; // thB 한테 양보 하라고 함
		thB.yield = true; // 0.5 초 후에
		
		// 둘 다 정지
		thA.stop = true; 
		thB.stop = true; 
		
	}

}
