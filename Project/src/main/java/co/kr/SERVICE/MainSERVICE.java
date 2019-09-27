package co.kr.SERVICE;

import java.util.List;

import co.kr.VO.MemberVO;

public interface MainSERVICE {
	
	public MemberVO AccountInfo(String member_Id);
	public List<MemberVO> AccountListAll(String member_Id, String member_Interesting);
	
}
