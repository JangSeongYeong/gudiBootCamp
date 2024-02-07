package chap11.ex05;

public class Main { 
	
	private static Thread.State state;
	
	public static void main(String[] args) {

		WorkThread work = new WorkThread(); // 스레드 생성
		state = work.getState();
		System.out.println("Thread state : "+state);
		work.start(); // 스레드 실행

		// 계속해서 워크 스레드의 상태를 가져와 출력
		while (true) {
			state = work.getState();
			System.out.println("Thread state : "+state);
		
			// 워크스레드가 종료되면 반복문 탈출
			if (state == Thread.State.TERMINATED) {
				break;
			}
		}
	
	
	}

}
