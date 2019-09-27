package co.kr.DAO;

import java.util.List;

import co.kr.VO.MemberVO;

public interface MainDAO {
	
	public MemberVO memberInfo(String member_Id);
	
	public List<MemberVO> memberListAll(String member_Id, String member_Interesting);
	
	
	
}
