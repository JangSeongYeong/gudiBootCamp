package chap08.ex09;

public class JoinMember {

	public void reservedCheck(String id) {
		
		String[] reserved = {"admin", "tester", "manager"}; // 예약어, 여기에 있는 이름으로는 회원 가입 못 함
		for (String r : reserved) {
			if(r.equals(id)) {
				// 예약어라면 예외 발생
				throw new ReservedException(id+ "는 예약어 입니다.");
			}
		}
		
	}
	
	public void ageCheck(int age) throws AdultException {
		
		if(age<20) {
			throw new AdultException("성인만 가입 가능합니다.");
		}
		
	}
	
}
