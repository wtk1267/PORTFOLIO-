package co.kr.soldesk;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.MessageDAO;
import co.kr.VO.MessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MessageTest {
	
	@Inject
	private MessageDAO mdao;
	
	private Logger logger = LoggerFactory.getLogger(MessageController.class);

	
//	@Test
//	public void messageSendTest() {
//		MessageVO mvo = new MessageVO();
//		
//		mvo.setMember_Id("123");
//		mvo.setMsg_Send_Id("123");
//		mvo.setMsg_Receive_Id("정보공개1");
//		mvo.setMsg_Subject("정보공개1에게");
//		mvo.setMsg_Contents("내용테스트 테스또!~!~!~!~");
//		
//		System.out.println(mdao.MessageSend(mvo));
//	}//messageSendTest() end 
	
//	@Test
//	public void sendMsgListTest() {
//		mdao.SendMessageList("123");
//	}//보낸 편지함 리스트
	
//	@Test
//	public void receiveMsgListTest() {
//		mdao.ReceiveMessageList("123");
//	}//받은 편지함 리스트

//	@Test
//	public void msgDetailTest() {
//		mdao.messageDetail(3);
//	}//메시지 내용 확인 
	
	@Test
	public void msgStatusConverterTest() {
		mdao.statusCon(3);
	}
	
	
	
	
	
}//class end 
