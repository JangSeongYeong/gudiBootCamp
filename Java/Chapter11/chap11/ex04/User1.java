package chap11.ex04;

public class User1 extends Thread {
	
	private Computer com;
	
	public User1(Computer com) {
		setName("user 1");
		this.com = com;
	}

	@Override
	public void run() {
		com.setScore(500); // user 1 은 점수를 500점으로 만들어 놨다.
	}
	
	

}
