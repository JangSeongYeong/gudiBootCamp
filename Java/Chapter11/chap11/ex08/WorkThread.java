package chap11.ex08;

public class WorkThread extends Thread {

	private WorkObj obj; // 객체를 따로 필드로 담고 있으면 UML 상 실선이라고 이해하자
	
	public WorkThread(WorkObj obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		
		for (int i = 1; i <= 5; i++) {
			obj.work();
		}
		
	}
	
}
