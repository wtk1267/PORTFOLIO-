package co.kr.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.VO.PlanVO;

@Repository
public class PlanDAOImple implements PlanDAO{

	@Inject
	private SqlSession ss;
	
	@Override
	public void createSchedule(PlanVO pvo) {
		ss.insert("insertPlan", pvo);
		
	}

	@Override
	public List<PlanVO> listSchedule(String member_Id) {
		return ss.selectList("selectList", member_Id);
	}

	@Override
	public void planDelete(Integer schedule_Id) {
		ss.delete("deletePlan", schedule_Id);
	}

	@Override
	public void planModify(PlanVO pvo) {
		ss.update("modifyPlan", pvo);
		
	}


}
