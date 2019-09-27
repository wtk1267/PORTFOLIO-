package co.kr.soldesk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.MidiDevice.Info;

import org.junit.platform.suite.api.IncludeTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import co.kr.SERVICE.BoardSERVICE;
import co.kr.VO.BoardVO;
import co.kr.VO.PageCriteria;
import co.kr.VO.PagingMaker;
import co.kr.VO.findCriteria;
import jdk.nashorn.internal.runtime.FindProperty;

@RequestMapping(value = "/board/*")
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	
	@Inject
	private BoardSERVICE bser;
	
	
	@RequestMapping(value = "boardList", method = RequestMethod.GET)
	public String boardListMethod(Model model, HttpServletRequest req, findCriteria fCri) throws Exception {
		
		
		String board_Id = req.getParameter("board_Id"); 
		
		model.addAttribute("info", bser.selectAllList(board_Id, fCri));
		
		PagingMaker pm = new PagingMaker();
		
		pm.setpCri(fCri);
		
		pm.setTotalData(bser.listCountData(fCri, board_Id));
		
		model.addAttribute("pm", pm);
		
		return "board/boardMain";
	}
	
	@RequestMapping(value = "findList", method = RequestMethod.GET)
	public String boardListMethod2(Model model, HttpServletRequest req, findCriteria fCri) throws Exception {
		
		String board_Id = req.getParameter("board_Id"); 
		
		model.addAttribute("info", bser.findList(board_Id, fCri));
		
		PagingMaker pm = new PagingMaker();
		
		pm.setpCri(fCri);
		
		pm.setTotalData(bser.listCountData(fCri, board_Id));
		
		model.addAttribute("pm", pm);
		
		return "board/boardfind";
	}
	

	
	@RequestMapping(value = "boardWrite", method = RequestMethod.GET)
	public String boardWriteMethod(Model model, HttpServletRequest req) {
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "boardWrite", method = RequestMethod.POST)
	public String boardWriteMethod2(BoardVO bvo) throws UnsupportedEncodingException {

		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String board_Ip = req.getHeader("X-FORWARDED-FOR");
		 if (board_Ip == null)board_Ip = req.getRemoteAddr();
		bvo.setBoard_Ip(board_Ip);
		 
		
		String board_Id = URLEncoder.encode(req.getParameter("board_Id"), "UTF-8"); 
		logger.info("board_Id ::::::::::" + board_Id);
		
		bser.insertBoard(bvo);

		String returnvalue = "redirect:/board/boardList?board_Id="+board_Id;

		return returnvalue;
	}
	
	
	@RequestMapping(value = "boardModify", method = RequestMethod.GET)
	public String boardModifyMethod(Model model, HttpServletRequest req) {
		
		int board_No = Integer.parseInt(req.getParameter("board_No"));
		String board_Id = req.getParameter("board_Id");
		
		model.addAttribute("info", bser.selectOne(board_No, board_Id));

		
		
		return "board/boardModify";
	}
	
	@RequestMapping(value = "boardModify", method = RequestMethod.POST)
	public String boardDetailMethod2(BoardVO bvo, HttpServletRequest req) throws UnsupportedEncodingException {
		
		bser.modifyBoard(bvo);
		
		String board_Id = URLEncoder.encode(req.getParameter("board_Id"), "UTF-8"); 
		String returnvalue = "redirect:/board/boardList?board_Id="+board_Id;
		
		return returnvalue;
		
	}
		
		
	@RequestMapping(value = "boardDetail", method = RequestMethod.GET)
	public String boardDetailMethod(HttpServletRequest req, Model model) {
		
		int board_No = Integer.parseInt(req.getParameter("board_No"));
		
		bser.hitCount(board_No);
		
		String board_Id = req.getParameter("board_Id");
		
		model.addAttribute("info", bser.selectOne(board_No, board_Id));
		
		return "board/boardDetail";
	}
	
	
	@RequestMapping(value = "delOk", method = RequestMethod.POST)
	@ResponseBody
	public Map<Object, Object> delOkMethod(@RequestBody String writer, HttpServletRequest req){
		
		String member_Id = (String) req.getSession().getAttribute("id");
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		//String 끼리 비교는 == 보다는 equals를 이용해야함!
		if(!writer.equalsIgnoreCase(member_Id)) {
			map.put("result", 0);
			return map;
		}
		
		map.put("result", 1);
		

		return map;
	}
	
	@RequestMapping(value = "delcon", method = RequestMethod.POST)
	public String delconMethod(HttpServletRequest req, 
			@RequestParam("board_No") int board_No
			) throws UnsupportedEncodingException {
		
		String board_Id = URLEncoder.encode(req.getParameter("board_Id"), "UTF-8"); 
		
		String returnvalue = "redirect:/board/boardList?board_Id="+board_Id;
		
		bser.deleteBoard(board_No);
		
		logger.info("삭제 완료!!!!");
		
		
		return returnvalue;
	}
	
	
	
	
	
	
	
}//class end 
