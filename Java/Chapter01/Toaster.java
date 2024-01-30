
public class Toaster {

	public static void main(String[] args) {
		// 파일 이름 수정 할때는 파일 내에서 class명을 수정하는 것이 아닌 F2를 활용해서 파일을 직접 바꾼다.
		String dish = toaster("식빵");
		System.out.println(dish);
	}
	
	static String toaster(String input){
		System.out.println(input + "이 구워지고 있다.");
		return "구워진 "+input;
	}
		
}
