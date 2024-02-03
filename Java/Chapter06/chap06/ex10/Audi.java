package chap06.ex10;

public class Audi extends Car{
	
	@Override
	public String run() {
		return "Audi "+super.run();
	}
}
