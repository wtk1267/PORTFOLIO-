package co.kr.DAO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import co.kr.VO.FriendsVO;
import co.kr.VO.MemberVO;

@Repository
public class FriendsDAOImple implements FriendsDAO{

	@Inject
	private SqlSession ss;
	
	@Override
	public void addFriends(FriendsVO fvo) {
		ss.insert("friendsAdd", fvo);
		
	}

	@Override
	public int existFriends(FriendsVO fvo) {
		return ss.selectOne("existFriends", fvo);
	}

	@Override
	public List<MemberVO> listfriends(String member_Id) {
		return ss.selectList("friendsList", member_Id);
	}

	@Override
	public int friendsBan(FriendsVO fvo) {
		return ss.update("friendsMsgBan", fvo);
	 
	}

	@Override
	public int findStatus(FriendsVO fvo) {
		return ss.selectOne("searchStatus", fvo);
	}

	@Override
	public int friendsBanCancel(FriendsVO fvo) {
		return ss.update("friendsMsgBanCancel", fvo);
	}

	@Override
	public int delFriends(FriendsVO fvo) {
		return ss.delete("deleteFriends", fvo);
	}

}
