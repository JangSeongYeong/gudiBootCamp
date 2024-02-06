package chap11.ex03;

public class Main {

	public static void main(String[] args) {
		
		Thread th1 = new WorkThread();
		th1.setName("첫번째 스레드"); // Thread 이름 수정
		th1.start(); // Thread-0
		
		Thread th2 = new WorkThread();
		th2.setName("두번째 스레드");
		th2.start(); // Thread-1
		
		Thread th3 = new WorkThread();
		th3.setName("세번째 스레드");
		th3.start(); // Thread-2
		
		
	}

}
