package chap10.ex11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExam {

	public static void main(String[] args) throws IOException {
		// java.io.File <- java io
		// java.nio.Files <- java nio : 오직 파일만을 사용
		// Files 를 쓰기 위해서는 Paths 를 통해 경로를 설정해야 한다.
		
		Path path = Paths.get("C:/img/high.mp4"); // Files 를 쓰기 위해서는 Paths 를 통해 경로를 설정해야 한다.
		System.out.println("디렉토리 여부 : "+Files.isDirectory(path));
		System.out.println("파일 여부 : "+Files.isRegularFile(path));
		System.out.println("마지막 수정 시간 : "+Files.getLastModifiedTime(path));
		System.out.println("파일 크기 : "+Files.size(path)/1024+"KB");
		System.out.println("소유자 : "+Files.getOwner(path));
		System.out.println("숨김 파일 여부 : "+Files.isHidden(path));
		System.out.println("읽기 가능 여부 : "+Files.isReadable(path));
		System.out.println("쓰기 가능 여부 : "+Files.isWritable(path));
		
		// 폴더 생성
		Path dir = Paths.get("C:/img/nio");
		if(Files.notExists(dir)){ // 경로에 없는지 확인
			Files.createDirectory(dir);
		}
		
		// 파일 생성
		Path file = Paths.get("C:/img/nio/textFile.txt");
		Files.createFile(file);
		
	}

}
