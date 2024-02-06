package chap11.ex04;

public class Computer {
	private int score;
	
	/*
	public void setScore(int score) {
		
		// 내가 점수를 만들어 놓고
		this.score = score;
		try {
			Thread.sleep(2000); // 2초간 자리를 비운 후 (누군가 이 사이 점수를 건드릴 수 있다.)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 돌아와서 다시 점수 확인
		System.out.println(Thread.currentThread().getName()+" : "+this.score);
		
	}
	*/
	
	// synchronized : 오직 하나만 사용하고 나머지는 줄 서서 기다리게 만드는 기능
	// synchronized method - 메서드 진입 자체를 막는다.
	// 간섭 현상이 있다고 생각하면 사용
	/*
	public synchronized void setScore(int score) {
		
		this.score = score;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" : "+this.score);
	}
	*/
	
	// synchronized block - 메서드 안의 특정 영역 진입을 막는다.
	// 간섭 현상이 없다고 생각하면 사용
	public void setScore(int score) {
		
		synchronized (this) {
			this.score = score;
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+" : "+this.score);			
		}
	}
}
