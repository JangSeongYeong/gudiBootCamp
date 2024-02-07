package chap11.ex07;

public class MainThread {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("1~100 까지의 합은?");
		
		// 워크 스레드에게 계산 시킴
		OperThread oper = new OperThread();
		oper.start();

		// 왜 0이 나오는지?
		// 계산을 하기도 전에 출력을 요청해서 0이 나오게 된다
		// oper.sleep(1); // Solution 1. sleep 을 이용함으로 계산 시간을 준다. (시간 낭비가 발생)
		oper.join(); // Solution 2. oper 가 일을 완료할때까지 기다린다.(block) -> 동기방식이라고 한다. (하나가 끝날떄까지 기다림)
		
		System.out.println("답 : "+oper.getSum());
		
	}

}
