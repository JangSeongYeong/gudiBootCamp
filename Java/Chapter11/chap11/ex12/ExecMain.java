package chap11.ex12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecMain {

	public static void main(String[] args) {

		// 1. 스레드 풀 생성
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		// 2. 빌려달라고 양식 작성 (반환값 유무)
		// 없을 경우 - Runnable 구현
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("thread pool - "+Thread.currentThread().getName());
			}
		};
		
		// 3. 빌려달라고 요청 - return이 없기에 excute()
		pool.execute(run);
		
		// 4. 스레드 풀 종료
		// pool.shutdown(); 끝까지 기다린다.
		pool.shutdownNow(); // 아예 기다리지 않는다.
	
	}

}
