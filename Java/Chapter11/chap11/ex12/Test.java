package chap11.ex12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		// 1. Thread pool 을 생성한다. (1개)
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);

		// 2. 수행할 작업을 만든다. ( runnable or callable )
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				// 10개의 스레드가 1번씩 출력
				System.out.println("Thread Pool : "+Thread.currentThread().getName());
			}
		};
		
		// 3. 작업을 요청 한다. (끝나면 반환)
		for (int i = 0; i < 10; i++) {
			pool.execute(run);
		}
		
		// 4. 더 이상 요청하지 않으면 pool 을 종료한다.
		pool.shutdown();
		boolean end = pool.awaitTermination(1L, TimeUnit.SECONDS);
		System.out.println("종료 여부 : "+end);
	}

}
