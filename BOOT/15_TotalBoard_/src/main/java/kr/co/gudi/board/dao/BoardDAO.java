package kr.co.gudi.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.board.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	List<BoardDTO> list();

	int write(BoardDTO dto);

	BoardDTO detail(String bbs_idx);

	void upHit(String bbs_idx);

	int del(String idx);

	int update(Map<String, String> param);


}
