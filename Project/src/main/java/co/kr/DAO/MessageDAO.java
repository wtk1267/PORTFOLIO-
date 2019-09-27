package co.kr.DAO;

import java.util.List;

import co.kr.VO.MessageVO;

public interface MessageDAO {

	public int MessageSend(MessageVO mvo);

	public List<MessageVO> SendMessageList(String member_Id);
	
	public List<MessageVO> ReceiveMessageList(String member_Id);
	
	public MessageVO messageDetail(Integer msg_Id);

	public void statusCon(Integer msg_Id);
	
}
