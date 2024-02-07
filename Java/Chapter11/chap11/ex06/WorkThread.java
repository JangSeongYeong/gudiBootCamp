package chap11.ex06;

public class WorkThread extends Thread {

	boolean stop = false;
	boolean yield = false;
	
	@Override
	public void run() {
		
		while (!stop) {
			System.out.println(getName()+" 동작");
			if (yield==true) {
				System.out.println(getName()+" 이 양보");
				Thread.yield();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	
		System.out.println(getName()+" 중지");
	}
	
}
