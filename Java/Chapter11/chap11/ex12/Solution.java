package chap11.ex12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Solution {

	public static void main(String[] args) throws InterruptedException {
		// 풀 생성 (1개)
		int n = Runtime.getRuntime().availableProcessors();
		ExecutorService pool = Executors.newFixedThreadPool(n);
		
		// 해야할 일 작성 (Runnable | Callable)
		Runnable run = new Runnable() {
			@Override
			public void run() { 
				// 1개의 스레드가 10번 출력
				for (int i = 0; i < 10; i++) {
					System.out.println("Thread Pool : "+Thread.currentThread().getName());
				}
			}
		};
		
		// 실행 (excute() | submit())
		pool.execute(run);
		
		// 풀 종료
		pool.shutdown();
		boolean end = pool.awaitTermination(1L, TimeUnit.SECONDS);
		System.out.println("종료 여부 : "+end);
	}

}
