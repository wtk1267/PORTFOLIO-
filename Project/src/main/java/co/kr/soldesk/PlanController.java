package co.kr.soldesk;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import co.kr.SERVICE.PlanSERVICE;
import co.kr.VO.PlanVO;

@RequestMapping(value = "/plan/*")
@Controller
public class PlanController {
	
	@Inject
	private PlanSERVICE pser; 
	
	
	private Logger logger = LoggerFactory.getLogger(PlanController.class);
	
	
	@RequestMapping(value = "/plan", method = RequestMethod.GET)
	public String PlanMain() {
		
		return "myPlan/plan";
	}
	
	@RequestMapping(value = "popUp", method = RequestMethod.GET)
	public String planPopUp() {
		return "myPlan/popUp";
	}
	@RequestMapping(value = "popUpModify", method = RequestMethod.GET)
	public String planPopUpModify() {
		return "myPlan/popUpModify";
	}
	
	
	
	@RequestMapping(value = "saveSchedule", method = RequestMethod.POST)
		@ResponseBody
		public Map<Object, Object> saveSchedule(@RequestBody PlanVO pvo, HttpServletRequest req) {

		String member_Id = (String) req.getSession().getAttribute("id");
		
		pvo.setMember_Id(member_Id);

		pser.insertSchedule(pvo);
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		
		map.put("result", 1);
		
		return map;
	}
	
	@RequestMapping(value = "viewSchedule", method = {RequestMethod.POST, RequestMethod.GET})
	public void viewScheduleMehthod(HttpServletRequest req, HttpServletResponse response) {
		
		//String member_Id = (String) req.getSession().getAttribute("id");
		
		String member_Id = req.getParameter("member_Id");
		
		
		List<PlanVO> plist = pser.readSchedule(member_Id);
		
		JSONObject jsonContents = new JSONObject();
		JSONArray data = new JSONArray();
		
		for(PlanVO pvo : plist) {
			jsonContents = new JSONObject();
			jsonContents.put("id", pvo.getSchedule_Id());
			jsonContents.put("title", pvo.getSchedule_Subject());
			jsonContents.put("start", pvo.getSchedule_StartDate());
			jsonContents.put("end", pvo.getSchedule_EndDate());
			data.add(jsonContents);
		}
		
		
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter writer;
			writer = response.getWriter();
			writer.print(data.toString());
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} //viewScheduleMehthod() end 
	
	
	@RequestMapping(value = "deletePlan", method = RequestMethod.GET)
	public void deletePlanMethod(PlanVO pvo) {
		int schedule_Id = pvo.getSchedule_Id();
		
		pser.deletePlan(schedule_Id);
	}
	
	@RequestMapping(value = "modifyPlan", method = RequestMethod.POST)
	public void modifyPlanMethod(PlanVO pvo) {
		pser.modifyPlan(pvo);
	}
	
	
}//class end 

