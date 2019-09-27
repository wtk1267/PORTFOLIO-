package co.kr.SERVICE;

import java.util.List;

import co.kr.VO.FriendsVO;
import co.kr.VO.MemberVO;

public interface FriendsSERVICE {
	public void registFriends(FriendsVO fvo);
	
	public int existFriend(FriendsVO fvo);
	
	public List<MemberVO> friendsList(String member_Id);
	
	public int banFriends(FriendsVO fvo);
	
	public int banCancelFriends(FriendsVO fvo);

	public int searchStatus(FriendsVO fvo);
	
	public int deleteFriends(FriendsVO fvo);
}
