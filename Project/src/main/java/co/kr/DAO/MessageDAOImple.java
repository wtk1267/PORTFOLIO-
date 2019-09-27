package co.kr.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.VO.MessageVO;

@Repository
public class MessageDAOImple implements MessageDAO{

	@Inject
	private SqlSession ss;

	@Override
	public int MessageSend(MessageVO mvo) {
		return ss.insert("sendMessage", mvo);
	}

	@Override
	public List<MessageVO> SendMessageList(String member_Id) {
		return ss.selectList("sendMsgList", member_Id);
	}

	@Override
	public List<MessageVO> ReceiveMessageList(String member_Id) {
		return ss.selectList("receiveMsgList", member_Id);
	}

	@Override
	public MessageVO messageDetail(Integer msg_Id) {
		return ss.selectOne("msgDetail", msg_Id);
	}

	@Override
	public void statusCon(Integer msg_Id) {
		ss.update("statusConverter", msg_Id);
	}
	
	
	
	
}
