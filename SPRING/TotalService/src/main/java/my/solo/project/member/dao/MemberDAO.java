package my.solo.project.member.dao;

import java.util.Map;

import my.solo.project.member.dto.MemberDTO;

public interface MemberDAO {

	int overlay(String id);

	int join(Map<String, String> map);

	void grant(String string, String perm);

	MemberDTO login(String id, String pw);

}
