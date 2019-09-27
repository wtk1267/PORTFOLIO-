package co.kr.DAO;

import java.util.List;

import co.kr.VO.BoardVO;
import co.kr.VO.PageCriteria;
import co.kr.VO.findCriteria;

public interface BoardDAO {

	public List<BoardVO> AllList(String board_Id, PageCriteria pCri);
	public int countData(PageCriteria pCri, String board_Id) throws Exception;
	
	public void writerBoard(BoardVO bvo);
	
	public BoardVO listOne(Integer board_No, String board_Id);
	
	public void modiBoard(BoardVO bvo);
	
	public void delBoard(Integer board_No);
	
	public List<BoardVO> searchList(String board_Id, findCriteria fCri);
	
	public void hitincre (Integer board_No);
	
}
