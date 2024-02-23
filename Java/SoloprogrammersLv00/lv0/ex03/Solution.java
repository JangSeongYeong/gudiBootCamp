package lv0.ex03;

public class Solution {

	public int solution(int price) {
		// 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인.
		// 가격 price, 금액 return
		double answer = 0;
		double discount = 0;
		
		if(price >= 500000) {
			discount = (double)price * 0.2;
		} else if(price >= 300000) {
			discount = (double)price * 0.1;
		} else if(price >= 100000) {
			discount = (double)price * 0.05;
		} else {
			return price;
		}
		// 이 부분이 중요 price 를 double 로 안바꾸고 discount 를 
		// int 형변환을 통해 계산을 할 경우 값이 다르게 나오는 case 가 있음 
		answer = (double)price - discount;
		
        return (int)answer;
    }
}
