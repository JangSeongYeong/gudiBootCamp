
public class AndOr {

	public static void main(String[] args) {
		
		int val = 6;
		
		if (val > 1 && val < 7) {
			System.out.println(val+"은 1보다 크고 7보다 작군요");
		}
		
		if (val % 2 == 0 || val % 3 == 0) {
			System.out.println("2 또는 3의 배수");
		}
		
	}

}
