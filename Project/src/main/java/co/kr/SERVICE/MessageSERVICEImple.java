package co.kr.SERVICE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.DAO.MessageDAO;
import co.kr.VO.MessageVO;

@Service
public class MessageSERVICEImple implements MessageSERVICE{

	@Inject
	private MessageDAO mdao;

	@Override
	public int sendMessage(MessageVO mvo) {
		return mdao.MessageSend(mvo);
	}

	@Override
	public List<MessageVO> SendMsgList(String member_Id) {
		return mdao.SendMessageList(member_Id);
	}

	@Override
	public List<MessageVO> ReceiveMsgList(String member_Id) {
		return mdao.ReceiveMessageList(member_Id);
	}

	@Override
	public MessageVO msgDetail(Integer msg_Id) {
		return mdao.messageDetail(msg_Id);
	}

	@Override
	public void statusConverter(Integer msg_Id) {
		mdao.statusCon(msg_Id);
	}
	
	
	
	
	
}
