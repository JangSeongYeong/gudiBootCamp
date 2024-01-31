package chap05.ex12;

public class Computer {

	private boolean power;
	private int panSpeed;
	private int temp;
	
	// private 는 다른 클래스에서 수정이 안되기 때문에 
	// 수정이 필요하다면 getter, setter 를 이용하여 수정한다.
	
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
		
		if(power) { // 피워를 켜면 팬이 돌고 온도가 올라간다.
			panSpeed = 50;
			temp = 60;
		} else { // 끄면 팬이 멈추고 온도가 내려간다.
			panSpeed = 0;
			temp = 20;
		}
	}
	public int getPanSpeed() {
		return panSpeed;
	}
	public void setPanSpeed(int panSpeed) {
		this.panSpeed = panSpeed;
		// 우리끼리 정한 공식 (110 - 팬스피드 = 온도)
		this.temp = 110 - panSpeed;
	}
	public int getTemp() {
		return temp;
	}

}
