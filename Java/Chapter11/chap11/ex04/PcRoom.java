package chap11.ex04;

public class PcRoom {

	public static void main(String[] args) {
		
		// 공용 컴퓨터
		Computer com = new Computer();
		
		// 컴퓨터를 각 유저에게 전달
		User1 user1 = new User1(com);
		User2 user2 = new User2(com);
		
		// 사용
		user1.start(); // 500
		user2.start(); // 200
		
		
		
	}

}
