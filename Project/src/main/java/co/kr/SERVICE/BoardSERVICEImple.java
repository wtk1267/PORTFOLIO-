package co.kr.SERVICE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.DAO.BoardDAO;
import co.kr.VO.BoardVO;
import co.kr.VO.PageCriteria;
import co.kr.VO.findCriteria;

@Service
public class BoardSERVICEImple implements BoardSERVICE {

	@Inject
	private BoardDAO bdao;
	
	@Override
	public List<BoardVO> selectAllList(String board_Id, PageCriteria pCri) {
		return bdao.AllList(board_Id, pCri);
	}

	@Override
	public void insertBoard(BoardVO bvo) {
		bdao.writerBoard(bvo);
	}

	@Override
	public BoardVO selectOne(Integer board_No, String board_Id) {
		return bdao.listOne(board_No, board_Id);
	}

	@Override
	public int listCountData(PageCriteria pCri, String board_Id) throws Exception {
		return bdao.countData(pCri, board_Id);
	}

	@Override
	public void modifyBoard(BoardVO bvo) {
		bdao.modiBoard(bvo);
	}

	@Override
	public void deleteBoard(Integer board_No) {
		bdao.delBoard(board_No);
	}

	@Override
	public List<BoardVO> findList(String board_Id, findCriteria fCri) {
		return bdao.searchList(board_Id, fCri);
	}

	@Override
	public void hitCount(Integer board_No) {
		bdao.hitincre(board_No);
	}
	
	

	
	
	
	
	
	
}//class end 
