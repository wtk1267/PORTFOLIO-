package co.kr.SERVICE;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.DAO.MemberDAO;
import co.kr.VO.MemberVO;

@Service
public class MemberSERVICEImple implements MemberSERVICE{

	@Inject
	private MemberDAO mdao;
	
	
	@Override
	public void CreateAccount(MemberVO mvo) {
		mdao.insertDAO(mvo);
	}


	@Override
	public int existById(String member_Id) {
		return mdao.isExistId(member_Id);
	}


	@Override
	public int loginConfirm(String member_Id, String member_Password) {
		// TODO Auto-generated method stub
		return mdao.loginmethod(member_Id, member_Password);
	}


	@Override
	public void modifyInfoDAO(MemberVO mvo) {
		mdao.updateDAO(mvo);
	}


	@Override
	public void deleteService(String member_Id) {
		mdao.deleteDAO(member_Id);
		
	}

}
