package co.kr.SERVICE;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import co.kr.DAO.FriendsDAO;
import co.kr.VO.FriendsVO;
import co.kr.VO.MemberVO;

@Service
public class FriendsSERVICEImple implements FriendsSERVICE{

	@Inject
	private FriendsDAO fdao;
	
	@Override
	public void registFriends(FriendsVO fvo) {
		fdao.addFriends(fvo);
	}

	@Override
	public int existFriend(FriendsVO fvo) {
		return fdao.existFriends(fvo);
	}

	@Override
	public List<MemberVO> friendsList(String member_Id) {

		return fdao.listfriends(member_Id);
	}

	@Override
	public int banFriends(FriendsVO fvo) {
		return fdao.friendsBan(fvo);
	}

	@Override
	public int searchStatus(FriendsVO fvo) {
		return fdao.findStatus(fvo);
	}

	@Override
	public int banCancelFriends(FriendsVO fvo) {
		return fdao.friendsBanCancel(fvo);
	}

	@Override
	public int deleteFriends(FriendsVO fvo) {
		return fdao.delFriends(fvo);
	}
	

}
