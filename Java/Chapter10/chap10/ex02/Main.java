package chap10.ex02;

import java.io.File;

public class Main {

	public static void main(String[] args) throws Exception {

		// java.io.File 객체는 파일과 디렉토리에 관련된 모든 기능을 가지고 있다.
		File dir = new File("C:/img/temp");
		
		// 1. 폴더가 존재하지 않으면 생성 하기
		if (dir.exists() == false) { // exists - 파일이 존재하면 true
			System.out.println("폴더 없음 생성 시작!");
			dir.mkdirs(); // mkdir 은 폴더 한개만 s면 복수, 만들어야 하는 폴더가 img와 temp 두개기에 s로 생성
		} 
		
		
		// 2. 파일 생성 하기 		// 파일을 건들이고 싶다면 파일객체가 필수
		File file = new File("C:/img/temp/test.txt");
		file.createNewFile(); // 일반 예외
		
		// 3. 폴더 정보 알아보기
		dir = new File("C:/");
		
		/*
		// 어떤 파일들이 있는지? (이름만 알아보기) - 파일과 폴더 이름을 다 알려주는데 구분은 안해준다.
		String[] fileNames = dir.list();
		for (String name : fileNames) {
			System.out.println(name);
		}
		*/
		
		File[] files = dir.listFiles(); 
		for (File f : files) {
			String gubun = "[파일]";
			
			if (f.isDirectory()) { // 폴더인지 아닌지 확인하는 메서드
				gubun = "[폴더]";
			}
			
			System.out.println(gubun+" "+f.getName()+" "+(f.length()/1024)+"KB"); // 사이즈당 단위는 1024배
			
		}
		
	}

}
