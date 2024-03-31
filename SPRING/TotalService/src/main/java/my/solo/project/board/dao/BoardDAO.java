package my.solo.project.board.dao;

import java.util.List;

import my.solo.project.board.dto.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> list(int start, int pagePerNum);

	int totalPages(int pagePerNum);

	List<String> delPhotos(String delIdx);

	int del(String delIdx);

	int write(BoardDTO dto);

	void fileSave(int idx, String ori_filename, String new_filename);

}
