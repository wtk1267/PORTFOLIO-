package co.kr.DAO;

import java.util.List;

import co.kr.VO.PlanVO;

public interface PlanDAO {
	
	public void createSchedule(PlanVO pvo);
	public List<PlanVO> listSchedule(String member_Id);
	
	public void planDelete(Integer schedule_Id);
	
	public void planModify(PlanVO pvo);
	
}
