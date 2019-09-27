package co.kr.SERVICE;

import co.kr.VO.MemberVO;

public interface MemberSERVICE {
	
	public void CreateAccount(MemberVO mvo); 
	
	public int existById(String member_Id);
	
	public int loginConfirm(String member_Id, String member_Password);
	
	public void modifyInfoDAO(MemberVO mvo);
	
	public void deleteService(String member_Id);
}
