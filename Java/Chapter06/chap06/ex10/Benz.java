package chap06.ex10;

public class Benz extends Car{
	
	@Override
	public String run() {
		return "Benz "+super.run();
	}
}
