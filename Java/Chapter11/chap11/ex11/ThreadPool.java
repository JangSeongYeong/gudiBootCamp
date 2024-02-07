package chap11.ex11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public static void main(String[] args) {
		
		ExecutorService pool = null;
		// 아무것도 없이 있다가 요청이 있으면 그때 만든다. (속도는 느리지만 메모리 낭비가 없다.)
		// 반납받은 스레드가 있으면 빌려준다.
		// 반납받은 스레드가 60초가 놀고 있으면 버린다. 
		// Cached (안가지고 있다가) 필요하면 그때그때 한다.
		// pool = Executors.newCachedThreadPool();
		
		// 초기에 n 개의 스레드를 구비하고 있는다. (속도는 빠르지만 메모리 낭비가 있다)
		// 일반적으로 n 은 CPU 에서 사용 가능한 메인 스레드 갯수
		int n = Runtime.getRuntime().availableProcessors(); // 스레드 갯수 확인
		System.out.println("main thread : "+n);
		pool = Executors.newFixedThreadPool(n);
		
	}

}
