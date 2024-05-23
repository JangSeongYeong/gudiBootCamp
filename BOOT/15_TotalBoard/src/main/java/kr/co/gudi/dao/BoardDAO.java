package kr.co.gudi.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.BoardDTO;

@Mapper
public interface BoardDAO {

	List<BoardDTO> list();

	int write(BoardDTO dto);

	int upHit(String idx);

	BoardDTO detail(String idx);

	int delete(String idx);

	void update(Map<String, String> params);

	
}
