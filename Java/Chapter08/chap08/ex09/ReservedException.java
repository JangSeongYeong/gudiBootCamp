package chap08.ex09;

// 실행 예외 - 실행 해 봐야 알 수 있는 예외
public class ReservedException extends RuntimeException {

	public ReservedException(String message) {
		super(message);
	}
	
}
