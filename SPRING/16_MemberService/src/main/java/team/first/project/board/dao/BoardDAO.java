package team.first.project.board.dao;

import java.util.List;
import java.util.Map;

import team.first.project.board.dto.BoardDTO;
import team.first.project.member.dto.MemberDTO;

public interface BoardDAO {

	int overlay(String id);

	int join(Map<String, String> param);

	void setPermission(String id, String perm);

	MemberDTO login(String id, String pw);

	List<BoardDTO> listCall();

	List<String> fileList(String idx);

	int del(String idx);

}
