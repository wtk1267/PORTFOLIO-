package co.kr.SERVICE;

import java.util.List;

import co.kr.VO.PlanVO;

public interface PlanSERVICE {

	public void insertSchedule(PlanVO pvo);
	
	public List<PlanVO> readSchedule(String member_Id);
	
	public void deletePlan(Integer schedule_Id);
	
	public void modifyPlan(PlanVO pvo);
	
}
