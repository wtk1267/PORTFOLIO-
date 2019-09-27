package co.kr.soldesk;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.MemberDAO;
import co.kr.VO.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberTest {

	@Inject
	private MemberDAO mdao;
	
	private static Logger logger = LoggerFactory.getLogger(MemberTest.class);
	
//	@Test
//	public void insertMemeberTest() {
//		MemberVO mvo = new MemberVO();
//		
//		mvo.setMember_Id("wtk1267");
//		mvo.setMember_Name("wootaekyun");
//		mvo.setMember_Password("1234");
//		mvo.setMember_Email("wtk1267@gmail.com");
//		
//		mdao.insertDAO(mvo);
//		
//	}
	
	@Test
	public void exitid() {
		 int exit = mdao.isExistId("wtk1267");
		 System.out.println("아이디 존재유무 : " + exit);
		 
	}
	
//	@Test
//	public void logincheck() {
//		int exit = mdao.loginmethod("123", "1234");
//		
//		System.out.println(exit);
//		
//	}//로그인 허용 함수
	
//	@Test
//	public void updateMemberInfoTest() {
//		MemberVO mvo = new MemberVO();
//		mvo.setMember_Email("aaa@naver.com");
//		mvo.setMember_Password("123");
//		mvo.setMember_Interesting("IT");
//		mvo.setMember_OpenInfo(1);
//		mvo.setMember_Id("a");
//		mvo.setMember_Image("default.jpg");
//		
//		mdao.updateDAO(mvo);
//	}//정보수정
	
//	@Test
//	public void deleteTest() {
//		
//		mdao.deleteDAO("a");
//	}//회원 탈퇴
	
	

	
	
	
}//class end 
