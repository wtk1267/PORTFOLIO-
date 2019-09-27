package co.kr.soldesk;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.BoardDAO;
import co.kr.VO.BoardVO;
import co.kr.VO.findCriteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardTest {

	@Inject
	private BoardDAO bdao;
	
//	@Test
//	public void ListAllTest() {
//		bdao.AllList("IT");
//	}//전체조회 테스트
	
	
//	@Test
//	public void writerBoardTest() {
//		BoardVO bvo = new BoardVO();
//		
//		bvo.setMember_Id("123");
//		bvo.setBoard_Subject("경제도 테스트!");
//		bvo.setBoard_Contents("경제도 테스트해봅시다");
//		bvo.setBoard_Ip("테스트아이피");
//		bvo.setBoard_Id("경제");
//		
//		
//		bdao.writerBoard(bvo);
//	}// 게시판 작성 테스트
	
//	@Test 
//	public void listOneTest() {
//		bdao.listOne(2, "IT");
//	}
	
//	@Test
//	public void modiBoardTest() {
//		BoardVO bvo = new BoardVO();
//		bvo.setBoard_Subject("수정테스트");
//		bvo.setBoard_Contents("성공했으면 좋겠드아!");
//		bvo.setBoard_No(322);
//		bdao.modiBoard(bvo);
//	} //수정테스트
	
//	@Test
//	public void deleteBoard() {
//	
//		bdao.delBoard(330);
//
//	}//게시글 삭제 
	
//	@Test
//	public void findBoard() {
//		findCriteria fCri = new findCriteria("123", "member_Id");
	
//		fCri.setNumPerPage(10);
//		
//		bdao.searchList("야구", fCri);
//		
//	}
	
//	@Test
//	public void hitCountTest() {
//		bdao.hitincre(334);
//	}//조회수 증가 함수 
	
	
}

