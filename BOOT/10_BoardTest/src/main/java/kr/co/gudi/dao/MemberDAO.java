package kr.co.gudi.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import kr.co.gudi.dto.MemberDTO;

@Mapper
public interface MemberDAO {

	MemberDTO login(Map<String, String> params);
	
}
