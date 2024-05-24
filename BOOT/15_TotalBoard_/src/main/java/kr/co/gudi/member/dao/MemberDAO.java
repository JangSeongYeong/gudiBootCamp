package kr.co.gudi.member.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	int login(String id, String pw);

}
