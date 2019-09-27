package co.kr.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.VO.BoardVO;
import co.kr.VO.PageCriteria;
import co.kr.VO.findCriteria;

@Repository
public class BoardDAOImple implements BoardDAO{

	@Inject
	private SqlSession ss;
	
	@Override
	public List<BoardVO> AllList(String board_Id, PageCriteria pCri) {
		
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("board_Id", board_Id);
		map.put("page", pCri);

		return ss.selectList("ListAll", map);
	}

	@Override
	public void writerBoard(BoardVO bvo) {

		ss.insert("insertInfo", bvo);
	}

	@Override
	public BoardVO listOne(Integer board_No, String board_Id) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("board_No", board_No);
		map.put("board_Id", board_Id);
		
		return ss.selectOne("listOnebyNo", map);
	}

	@Override
	public int countData(PageCriteria pCri, String board_Id) throws Exception {

		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("pCri", pCri);
		map.put("board_Id", board_Id);
		
		return ss.selectOne("countData", map);
	}

	@Override
	public void modiBoard(BoardVO bvo) {
		
		ss.update("modifyBoard", bvo);
		
	}

	@Override
	public void delBoard(Integer board_No) {
		
		ss.update("deleteBoard", board_No);
		
	}

	@Override
	public List<BoardVO> searchList(String board_Id, findCriteria fCri) {
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("board_Id", board_Id);
		map.put("fCri", fCri);
		
		return ss.selectList("searchList", map);
		
		
		
	}

	@Override
	public void hitincre(Integer board_No) {
		ss.update("hitCount", board_No);
	}


	
}
