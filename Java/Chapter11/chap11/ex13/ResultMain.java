package chap11.ex13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultMain {

	public static void main(String[] args) throws Exception {
		// 풀 생성
		ExecutorService pool = Executors.newCachedThreadPool();
		// 할 일
		Callable<Integer> call = new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				int sum = 0;
				for (int i = 1; i <= 100; i++) {
					sum += i;
				}
				System.out.println(sum);
				return sum;
			}
		};
		// 실행
		Future<Integer> fu = pool.submit(call);
		int sum = fu.get(); // blocking == join()
		// Future 객체에서 get() 메서드를 사용하면 답이 나올때까지 다른 스레드가 움직이지 못한다.
		System.out.println("1~100 까지의 합은? "+sum);
		// 풀 종료
		pool.shutdownNow();
		
		
		
	}

}
