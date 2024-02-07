package chap11.ex07;

public class OperThread extends Thread {

	private int sum = 0;

	public int getSum() {
		return sum;
	}
	
	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}
