package co.kr.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.VO.MemberVO;

@Repository
public class MainDAOImple implements MainDAO{

	@Inject
	private SqlSession ss;
	
	
	@Override
	public MemberVO memberInfo(String member_Id) {
		return ss.selectOne("memberInfo", member_Id);
	}


	@Override
	public List<MemberVO> memberListAll(String member_Id, String member_Interesting) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("member_Id", member_Id);
		map.put("member_Interesting", member_Interesting);
		System.out.println(member_Interesting);
		return ss.selectList("listAll", map);
	}

}
