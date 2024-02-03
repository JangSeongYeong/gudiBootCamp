package chap07.ex06;

public class Main {

	public static void main(String[] args) {
		
		Child child = new ChildImpl();
		
		child.click(1);
		child.dblclick(2);
		
		child.keyDown(47);
		child.keyUp(47);
		
		child.selectOne();
		child.checkOne();
		child.textField("아무거나");
	}

}
