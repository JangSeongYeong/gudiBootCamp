package kr.co.gudi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.TeamDTO;

@Mapper
public interface MainDAO {

	List<TeamDTO> list();

}
