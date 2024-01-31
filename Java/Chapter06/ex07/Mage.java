package chap06.ex07;

public class Mage {

	public static void main(String[] args) {
		
		Light light = new Light();
		System.out.println(light.casting());
		
		Fire fire = new Fire();
		System.out.println(fire.casting());
		
		Ice ice = new Ice();
		System.out.println(ice.casting());
		
	}

}
