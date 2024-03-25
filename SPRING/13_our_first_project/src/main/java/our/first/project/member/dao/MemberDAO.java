package our.first.project.member.dao;

import java.util.List;
import java.util.Map;

import our.first.project.member.dto.MemberDTO;

public interface MemberDAO {

	String login(String id, String pw);

	List<MemberDTO> memberList();

	int join(Map<String, String> param);

}
