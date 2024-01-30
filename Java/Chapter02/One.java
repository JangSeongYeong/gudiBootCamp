
public class One {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		
		x++; // 증가 나중에
		++y; // 증가 먼저
		
		System.out.println("x="+x);
		System.out.println("y="+y);
		
		x = 1;
		y = 1;
		int result1 = (++x)+10; // 12   x가 먼저 증가
		int result2 = (y++)+10; // 11   y가 계산을 마지고(y+10) 나서 증가
		
		System.out.println("result1 = "+result1);
		System.out.println("result2 = "+result2);
		
		/*  ++기 '앞'에 붙는다. (증가한 내용을 이용해 다른행동을 할 때)
		 *  ++가 '뒤'에 붙는다. (아령들고 나서 1세기) -> 카운트에 주로 활용
		*/
		
		
		// 반전 연산(! not)
		boolean yn = true;
		System.out.println("yn = "+yn);
		
		yn = !yn;
		System.out.println("!yn = "+yn);
		
		yn = !yn;
		System.out.println("!!yn = "+yn);
		
	}

}
