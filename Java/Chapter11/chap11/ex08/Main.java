package chap11.ex08;

public class Main {

	public static void main(String[] args) {

		// WorkObj 를 객체화 한다.
		WorkObj obj = new WorkObj();
		// 스레드 2개 생성해서 각각 나눠준다.
		WorkThread thA = new WorkThread(obj);
		thA.setName("Thread A");
		WorkThread thB = new WorkThread(obj);
		thB.setName("Thread B");
		
		// 그리고 실행
		thA.start();
		thB.start();
		
	}

}
