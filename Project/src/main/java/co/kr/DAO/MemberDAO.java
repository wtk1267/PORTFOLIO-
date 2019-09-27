package co.kr.DAO;

import co.kr.VO.MemberVO;

public interface MemberDAO {
	
	public void insertDAO(MemberVO mvo); 
	
	public int isExistId(String member_Id);
	public int loginmethod(String member_Id, String member_Password);
	
	public void updateDAO(MemberVO mvo);
	
	public void deleteDAO(String member_Id);
}
