package chap06.ex08;

public class ArrMage {

	public static void main(String[] args) {

		// Ice, Light, Fire 주문을 연속을 날릴 수 있도록 배열과, for 문을 활용해서 구현해 보자
		Spell[] spell = {new Ice(), new Light(), new Fire()};
		
		for(Spell s : spell) {
			System.out.println(s.casting());
		}
		
	}

}
