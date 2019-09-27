package co.kr.soldesk;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.PlanDAO;
import co.kr.VO.PlanVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PlanTest {

	@Inject
	private PlanDAO pdao;
	
	private Logger logger = LoggerFactory.getLogger(PlanTest.class);
	
	
//	@Test
//	public void insertPlanTEST() {
//		PlanVO pvo = new PlanVO();
//		pvo.setMember_Id("123");
//		pvo.setSchedule_Subject("junit 테스트");
//		pvo.setSchedule_StartDate("2019-09-01");
//		pvo.setSchedule_EndDate("2019-09-04");
//		pdao.createSchedule(pvo);
//	}// 계획 삽입 테스트

//	@Test
//	public void selectListTest() {
//		pdao.listSchedule("123");
//	}// 아이디별로 플랜 조회 테스트
	
//	@Test
//	public void deletePlanTest() {
//		pdao.planDelete("6");
//	}//일정 삭제 테스트
	
//	@Test
//	public void modifyPlanTest() {
//		PlanVO pvo = new PlanVO();
//		pvo.setSchedule_Subject("수정까지 완료했다 만세");
//		pvo.setSchedule_StartDate("2019-09-01");
//		pvo.setSchedule_EndDate("2019-09-25");
//		pvo.setSchedule_Id(10);
//		
//		pdao.planModify(pvo);
//	}//일정 수정 테스트
	
}
