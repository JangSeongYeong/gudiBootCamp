package chap06.ex08;

public class Mage {

	public static void main(String[] args) {
		Spell spell;
		spell = new Ice();
		System.out.println(spell.casting());
		
		spell = new Light();
		System.out.println(spell.casting());
		
		spell = new Fire();
		System.out.println(spell.casting());
		
		// 다형성을 사용시 변수 하나에 다른 객체를 넣어서 사용해 메모리 낭비를 막을 수 있다.
	}

}
