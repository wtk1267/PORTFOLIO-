package co.kr.SERVICE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.DAO.PlanDAO;
import co.kr.VO.PlanVO;

@Service
public class PlanSERVICEImple implements PlanSERVICE{

	@Inject
	private PlanDAO pdao;
	
	@Override
	public void insertSchedule(PlanVO pvo) {
		pdao.createSchedule(pvo);
	}

	@Override
	public List<PlanVO> readSchedule(String member_Id) {
		return pdao.listSchedule(member_Id);
	}

	@Override
	public void deletePlan(Integer schedule_Id) {
		pdao.planDelete(schedule_Id);
	}

	@Override
	public void modifyPlan(PlanVO pvo) {
		pdao.planModify(pvo);
	}
	

	
	
	
	
}//class end 
