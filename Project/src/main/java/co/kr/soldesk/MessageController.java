package co.kr.soldesk;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.kr.SERVICE.MessageSERVICE;
import co.kr.VO.MessageVO;

@Controller
@RequestMapping(value = "/msg/*")
public class MessageController {

	private Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Inject
	private MessageSERVICE mser;
	
	
	@RequestMapping(value = "receiveMsgMain")
	public String receiveMsgMainMethod(Model model, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		model.addAttribute("info", mser.ReceiveMsgList(member_Id));
		
		return "msg/myReceiveMsg";
	}//receiveMsgMainMethod() end 
	
	
	
	
	@RequestMapping(value = "sendMsgMain")
	public String sendMsgMainMethod(Model model, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		model.addAttribute("info", mser.SendMsgList(member_Id));
		
		return "msg/mySendMsg";
	}//sendMsgMainMethod() end 
	
	
	
	@RequestMapping(value = "writeMsgMain", method = RequestMethod.GET)
	public String writeMsgMainMethodget() {
		
		return "msg/msgWrite";
	}//writeMsgMainMethod() end 
	
	@RequestMapping(value = "writeMsgMain", method = RequestMethod.POST)
	public void writeMsgMainMethodpost(MessageVO mvo, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		mvo.setMember_Id(member_Id); mvo.setMsg_Send_Id(member_Id); 
	
		mser.sendMessage(mvo);
	}

	
	@RequestMapping(value = "msgDetail")
	public String msgDetailMethod(HttpServletRequest req, Model model) {
		
		int msg_Id = Integer.parseInt(req.getParameter("msg_Id"));
		
		mser.statusConverter(msg_Id);
		
		model.addAttribute("info", mser.msgDetail(msg_Id));
		
		return "msg/msgDetail";
	}
	
}//class end 
