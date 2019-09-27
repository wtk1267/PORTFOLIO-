package co.kr.soldesk;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.kr.DAO.FriendsDAO;
import co.kr.VO.FriendsVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class FriendsTest {

	@Inject
	private FriendsDAO fdao;
	
	
//	@Test
//	public void addFriendsTest(){
//		FriendsVO fvo = new FriendsVO();
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("a");
//
//		fdao.addFriends(fvo);
//	}// 친구추가 end
	
//	@Test
//	public void existFriendsTest() {
//		FriendsVO fvo = new FriendsVO();
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("정보공1");
//		
//		fdao.existFriends(fvo);
//	}//친구 존재 여부 
	
//	@Test
//	public void friendsListTest() {
//		fdao.listfriends("123");
//	} // 친구 리스트 출력  
	
//	@Test
//	public void friendsMsgBanTest() {
//		
//		FriendsVO fvo = new FriendsVO();
//		
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("정보공개1");
//		
//		System.out.println(fdao.friendsBan(fvo));
//
//	}//friendsMsgBanTest() end 
	
//	@Test
//	public void searchStatusTest() {
//		FriendsVO fvo = new FriendsVO();
//		
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("정보공개1");
//		int result = fdao.findStatus(fvo);
//		
//		System.out.println(result);
//		
//	}//searchStatusTest() end 
	
//	@Test
//	public void friendsMsgBanCancelTest() {
//		
//		FriendsVO fvo = new FriendsVO();
//		
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("imageconfirm");
//		
//		System.out.println(fdao.friendsBanCancel(fvo));
//		
//	}//friendsMsgBanCancelTest() end 
	
//	@Test
//	public void deleteFriendsTest() {
//		FriendsVO fvo = new FriendsVO();
//		
//		fvo.setMember_Id("123");
//		fvo.setFriends_Id("imageconfirm");
//		
//		System.out.println(fdao.delFriends(fvo));
//	}//deleteFriendsTest() end 
	
	
	
}
