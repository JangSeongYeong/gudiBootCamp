package team.first.project.member.dao;

import java.util.Map;

import team.first.project.member.dto.MemberDTO;

public interface MemberDAO {

	int overlay(String id);

	int join(Map<String, String> param);

	void setPermission(String id, String perm);

	MemberDTO login(String id, String pw);

}
