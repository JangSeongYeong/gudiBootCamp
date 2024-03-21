package kr.co.photo.board.dao;

import java.util.List;
import java.util.Map;

import kr.co.photo.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int delete(String idx);

	BoardDTO detail(String idx);

	void upHit(String idx);

	int write(Map<String, String> map);

	int update(Map<String, String> map);

}
