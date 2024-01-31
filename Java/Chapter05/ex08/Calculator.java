package chap05.ex08;

public class Calculator {

	// 두 수 또는 문자를 더하는 메서드 만들기
	// int, float, String, long, double
	
	// long, double;
	
	// long
	public long plusli(long val1, int val2) {
		return val1 + (long)val2;
	}
	
	public float pluslf(long val1, float val2) {
		return (float)val1 + val2;
	}
	
	public String plusls(long val1, String val2) {
		return val1+val2;
	}
	
	public long plusll(long val1, long val2) {
		return val1+val2;
	}

	public double plusld(long val1, double val2) {
		return (double)val1+val2;
	}
	
	// double
	public double plusdi(double val1, int val2) {
		return val1 + (double)val2;
	}
	
	public double plusdf(double val1, float val2) {
		return val1 + (double)val2;
	}
	
	public String plusds(double val1, String val2) {
		return val1+val2;
	}

	public double plusdl(double val1, long val2) {
		return val1+(double)val2;
	}
	
	public double plusdd(double val1, double val2) {
		return val1+val2;
	}

}
