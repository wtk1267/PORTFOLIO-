package co.kr.soldesk;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.MainDAO;
import co.kr.DAO.MemberDAO;
import co.kr.VO.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MainTest {
	
	@Inject
	private MainDAO mdao;
	
	private static Logger logger = LoggerFactory.getLogger(MainTest.class);

	
	
//	@Test
//	public void memberinfotest() {
//		MemberVO mvo = mdao.memberInfo("123");
//	} 개인정보 검색 함수
	

	@Test
	public void memberListAllTest() {
		List<MemberVO> list = mdao.memberListAll("김광현", "baseball");
	}
	
	
	
}
