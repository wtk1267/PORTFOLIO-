package co.kr.SERVICE;

import java.util.List;

import co.kr.VO.MessageVO;

public interface MessageSERVICE {

	public int sendMessage(MessageVO mvo);
	
	public List<MessageVO> SendMsgList(String member_Id);
	
	public List<MessageVO> ReceiveMsgList(String member_Id);
	
	public MessageVO msgDetail(Integer msg_Id);
	
	public void statusConverter(Integer msg_Id);
}
