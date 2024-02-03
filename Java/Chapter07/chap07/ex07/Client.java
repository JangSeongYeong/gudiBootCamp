package chap07.ex07;

public class Client {

	public static void main(String[] args) {
		
		VingsuMaker maker = new VingsuMaker();
		
		maker.make(new RedBeanVingsu());
		System.out.println();
		
		maker.make(new ChocoVingsu());
		System.out.println();
		
		maker.make(new CookieVingsu());
		
	}

}
