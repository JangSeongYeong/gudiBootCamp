
public class StmtElseIf {

	public static void main(String[] args) {
		// 우리가 가지고 있는 음료수 : 콜라, 생수, 오렌지 주스, 사이다, 에너지음료, 냉커피, 식혜
		String item = "커피";
		
		// item 의 값이 가지고 있는 음료이면 OOO 이 나왔습니다. 라고 출력해 보자.
		if (item.equals("콜라")) {
			System.out.println(item+"가 나왔습니다.");
		}	else if (item.equals("생수")) {
			System.out.println(item+"가 나왔습니다.");
		} else if (item.equals("오렌지주스")) {
			System.out.println(item+"가 나왔습니다.");
		}	else if (item.equals("사이다")) {
			System.out.println(item+"가 나왔습니다.");
		} else if (item.equals("에너지음료")) {
			System.out.println(item+"가 나왔습니다.");
		} else if (item.equals("냉커피")) {
			System.out.println(item+"가 나왔습니다.");
		} else if (item.equals("식혜")) {
			System.out.println(item+"가 나왔습니다.");
		}else {
			System.err.println(item+"은(는) 보유하지 않고 있습니다.");
		}
		
	}

}
