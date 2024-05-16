package kr.co.gudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.BoardDTO;

// 자동으로 Mybatis 를 사용하는 설정이 된다.
@Mapper
public interface MainDAO {

	List<BoardDTO> list();

}
