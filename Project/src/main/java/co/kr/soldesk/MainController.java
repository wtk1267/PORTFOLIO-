package co.kr.soldesk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.kr.SERVICE.FileUploadService;
import co.kr.SERVICE.MainSERVICE;
import co.kr.SERVICE.MemberSERVICE;
import co.kr.VO.MemberVO;

@RequestMapping(value = "/main/*")
@Controller
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Inject
	private MainSERVICE mser; 
	@Inject
	private MemberSERVICE memberser;
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String albumBoardMethod(HttpServletRequest request, Model model) {
		logger.info("Main 화면 실행....");
		
		String member_Id = (String) request.getSession().getAttribute("id");
		
		MemberVO mvo = mser.AccountInfo(member_Id);
		
		
		model.addAttribute("allList", mser.AccountListAll(member_Id, mvo.getMember_Interesting()));
		
		
		return "main/main";
		
	}
	
	@RequestMapping(value = "/infor")
	public String infor() {
		logger.info("공지사항...");
		
		return "main/infor";
	}

	@RequestMapping(value = "/logout")
	public String logoutMethod(HttpServletRequest req) {
		
		req.getSession().removeAttribute("id");
		logger.info("로그아웃됨");
		
		return "redirect:/register/login";
	}
	
	@RequestMapping(value = "/modifyInfo", method = RequestMethod.GET)
	public String updateInfo1(Model model, HttpServletRequest req) {
		String member_Id = (String) req.getSession().getAttribute("id");
		
		model.addAttribute("info", mser.AccountInfo(member_Id));
		
		
		return "main/modifyInfo";
	}

	@RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
	public String updateInfo2(MemberVO mvo, HttpServletRequest req 
							  ,@RequestParam("member_OpenInfo") int member_OpenInfo
							  ,@RequestParam("file1") MultipartFile file)throws Exception {
		
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		mvo.setMember_Id(member_Id);
		mvo.setMember_OpenInfo(member_OpenInfo);
		
		String url = fileUploadService.restore(file);
		mvo.setMember_Image(url);

		memberser.modifyInfoDAO(mvo);
		
		return "redirect:/main/main";
	}
	
	
	@RequestMapping(value = "/deleteMember", method = RequestMethod.GET)
	public String deleteMemberMethod() {
		
		return "main/deletemember";
	}
	
	@RequestMapping(value = "/deleteOk", method = RequestMethod.GET)
	public String deleteOkMethod(HttpServletRequest req) {

		String member_Id = (String) req.getSession().getAttribute("id");
		
		memberser.deleteService(member_Id);
		req.getSession().removeAttribute("id");
		
		
		return "redirect:/register/login";
	}
	
	@RequestMapping(value = "/selectInfo", method = RequestMethod.GET)
	public String selectInfoMethod(HttpServletRequest req, Model model) {
		String member_Id = req.getParameter("member_Id");
		
		model.addAttribute("member_Id", member_Id);

		return "redirect:/plan/plan";
	}
	
	
	
	
	
}
