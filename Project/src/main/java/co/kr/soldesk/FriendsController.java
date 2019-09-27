package co.kr.soldesk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.kr.SERVICE.FriendsSERVICE;
import co.kr.VO.FriendsVO;
import co.kr.VO.MemberVO;

@RequestMapping(value ="/friends/*")
@Controller
public class FriendsController {

	private Logger logger = LoggerFactory.getLogger(FriendsController.class);
	
	@Inject
	private FriendsSERVICE fser;
	
	
	@RequestMapping(value = "addFriends")
	public String addFriendsMethod(FriendsVO fvo, Model model, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		String friends_Id = fvo.getFriends_Id();
		
		
		model.addAttribute("friends_Id", friends_Id);
		
		return "myFriends/addFriends";
	}
	
	@RequestMapping(value = "registFriends")
	public void registFriendsMethod(FriendsVO fvo, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		fvo.setMember_Id(member_Id);
		
		fser.registFriends(fvo);
	}
	
	@RequestMapping(value = "FriendsCheck", method = RequestMethod.POST)
	@ResponseBody
	
	public Map<Object, Object> FriendsCheckMethod(@RequestBody String friends_Id, HttpServletRequest req) {
		
		int result = 0;
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		String member_Id = (String) req.getSession().getAttribute("id");

		FriendsVO fvo = new FriendsVO();
		
		fvo.setFriends_Id(friends_Id);
		
		fvo.setMember_Id(member_Id);
		
		result = fser.existFriend(fvo);
		
		map.put("result", result);
		
		return map;
	}//FriendsCheckMethod() end 
	

	
	@RequestMapping(value = "friendsMain")
	public String friendsMainMethod(HttpServletRequest req, Model model) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		
		List<MemberVO> list = fser.friendsList(member_Id);
		
		model.addAttribute("info", list);

		return "myFriends/friendsMain";
	}
	
	@RequestMapping(value = "friendsInfo")
	public String friendsInfoMethod(HttpServletRequest req, Model model) {
		
		String member_Id = req.getParameter("member_Id");
		
		model.addAttribute("member_Id", member_Id);
		
		return "redirect:/plan/plan";
	}//friends info end 
	
	@RequestMapping(value = "friendsStatus")
	public String friendsStatusMethod(FriendsVO fvo, Model model, HttpServletRequest req) {
		
		String member_Id = (String) req.getSession().getAttribute("id");
		String friends_Id = req.getParameter("friends_Id");
		
		fvo.setMember_Id(member_Id);
		fvo.setFriends_Id(friends_Id);
		
		int friends_Status1 = fser.searchStatus(fvo);
		String friends_Status = String.valueOf(friends_Status1);
		
		fvo.setFriends_Status(friends_Status);
		
		model.addAttribute("fvo", fvo);
		
		return "myFriends/statusFriends";
	}//friendsStatusMethod() end
	
	@RequestMapping(value="friendsMsgBan", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> friendsMsgBanMethod(@RequestBody String friends_Id, HttpServletRequest req){

		String member_Id = (String) req.getSession().getAttribute("id");
		
		FriendsVO fvo = new FriendsVO();
		
		fvo.setFriends_Id(friends_Id);
		
		fvo.setMember_Id(member_Id);
		
		int result = 0;

		result = fser.banFriends(fvo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("result", result);
		
		return map;
	}//friendsMsgBanMethod() end 
	
	@RequestMapping(value = "friendsMsgBanCancel", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> friendsMsgBanCancelMethod(@RequestBody String friends_Id, HttpServletRequest req){
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		FriendsVO fvo = new FriendsVO();
		
		fvo.setFriends_Id(friends_Id);
		
		fvo.setMember_Id(member_Id);
		
		int result = 0;
		
		result = fser.banCancelFriends(fvo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		
		map.put("result", result);
		
		return map;
	}
	
	@RequestMapping(value = "deleteFriends", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> deleteFriendsMethod(@RequestBody String friends_Id, HttpServletRequest req){
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		FriendsVO fvo = new FriendsVO();
		
		fvo.setMember_Id(member_Id); fvo.setFriends_Id(friends_Id);
		
		int result = 0;

		result = fser.deleteFriends(fvo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("result", result);
		
		return map;
	}
	
	
}//class end 
