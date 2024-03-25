package our.first.project.board.dao;

import java.util.List;

import our.first.project.board.dto.BoardDTO;
import our.first.project.board.dto.PhotoDTO;
import our.first.project.member.dto.MemberDTO;

public interface BoardDAO {

	List<BoardDTO> list();

	int write(BoardDTO dto);

	void fileWrite(String fileName, String newFileName, int idx);

	void upHit(String idx);

	BoardDTO detail(String idx);

	List<PhotoDTO> photos(String idx);

	List<MemberDTO> memberList();

}
