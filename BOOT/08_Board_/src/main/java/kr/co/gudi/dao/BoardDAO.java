package kr.co.gudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.BoardDTO;


@Mapper
public interface BoardDAO {

	List<BoardDTO> getBBSList();

	int bHit(String idx);

	BoardDTO detail(String idx);

}
