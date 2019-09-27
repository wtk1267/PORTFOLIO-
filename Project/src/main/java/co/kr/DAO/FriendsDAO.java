package co.kr.DAO;

import java.util.List;

import co.kr.VO.FriendsVO;
import co.kr.VO.MemberVO;

public interface FriendsDAO {
	public void addFriends(FriendsVO fvo);
	
	public int existFriends(FriendsVO fvo);
	
	public List<MemberVO> listfriends(String member_Id);
	
	public int friendsBan(FriendsVO fvo);
	
	public int friendsBanCancel(FriendsVO fvo);
	
	public int findStatus(FriendsVO fvo);
	
	public int delFriends(FriendsVO fvo);
	
	
}
