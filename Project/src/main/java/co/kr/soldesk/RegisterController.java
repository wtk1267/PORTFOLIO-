package co.kr.soldesk;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.SERVICE.FileUploadService;
import co.kr.SERVICE.MemberSERVICE;
import co.kr.VO.MemberVO;

@RequestMapping(value = "/register/*")
@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	FileUploadService fileUploadService;
	
	
	@Inject
	private MemberSERVICE mser;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerProcess(MemberVO mvo, Model model) {
		
		logger.info("회원가입중...");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerProcess2(
			MemberVO mvo
			,@RequestParam("member_OpenInfo") int member_OpenInfo
			, @RequestParam("file1") MultipartFile file) throws NullPointerException {
		
		mvo.setMember_OpenInfo(member_OpenInfo);
		
		logger.info("id::::" + mvo.getMember_Id() + "info:::::::::" + mvo.getMember_OpenInfo());
		
		String url = fileUploadService.restore(file);
		
		mvo.setMember_Image(url);
		
		logger.info(mvo.toString());
		
		mser.CreateAccount(mvo);
		
		
		logger.info("성공적으로 전송");
		
		return "redirect:/register/login";
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "register/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage2(Model model, 
			@RequestParam("member_Id") String member_Id,
			@RequestParam("member_Password") String member_Password,
			HttpServletRequest request) {
		
		
		int result = mser.loginConfirm(member_Id, member_Password);
		
		if(result == 0) {
			return "register/login";
		}
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id", member_Id);
		
		return "redirect:/main/main";
	}
	
	
	@RequestMapping(value = "/IdCheck", method = RequestMethod.POST)
		@ResponseBody
		public Map<Object, Object> IdCheckMethod(@RequestBody String member_Id){
		int result = 0;
		Map<Object, Object> map = new HashMap<Object, Object>();
		result = mser.existById(member_Id);
		map.put("result", result);
		return map;
	}
	
	
	
}
