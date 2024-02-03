package chap06.ex10;

public class Bmw extends Car{
	
	@Override
	public String run() {
		return "BMW "+super.run();
	}
}
