package co.kr.SERVICE;

import java.util.List;

import co.kr.VO.BoardVO;
import co.kr.VO.PageCriteria;
import co.kr.VO.findCriteria;

public interface BoardSERVICE {
	
	public List<BoardVO> selectAllList(String board_Id, PageCriteria pCri);

	public void insertBoard(BoardVO bvo);
	
	public BoardVO selectOne(Integer board_No, String board_Id);

	public int listCountData(PageCriteria pCri, String board_Id) throws Exception;

	public void modifyBoard(BoardVO bvo);

	public void deleteBoard(Integer board_No);
	
	public List<BoardVO> findList(String board_Id, findCriteria fCri);

	public void hitCount (Integer board_No);

}
