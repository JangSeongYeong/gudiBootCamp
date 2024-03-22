package kr.co.photo.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.photo.board.dto.BoardDTO;
import kr.co.photo.board.dto.PhotoDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int delete(String idx);

	BoardDTO detail(String idx);

	void upHit(String idx);

	int write(BoardDTO dto);

	int update(Map<String, String> map);

	void fileWrite(String fileName, String newFileName, int idx);

	List<PhotoDTO> photos(String idx);

	String[] delFileList(String idx);

}
