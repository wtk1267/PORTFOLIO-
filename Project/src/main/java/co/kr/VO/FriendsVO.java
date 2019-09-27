package co.kr.VO;

public class FriendsVO {
	
	private String member_Id;
	private String friends_Id;
	private String friends_Status;
	
	
	public FriendsVO() {}


	public FriendsVO(String member_Id, String friends_Id, String friends_Status) {
		super();
		this.member_Id = member_Id;
		this.friends_Id = friends_Id;
		this.friends_Status = friends_Status;
	}


	public String getMember_Id() {
		return member_Id;
	}


	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}


	public String getFriends_Id() {
		return friends_Id;
	}


	public void setFriends_Id(String friends_Id) {
		this.friends_Id = friends_Id;
	}


	public String getFriends_Status() {
		return friends_Status;
	}


	public void setFriends_Status(String friends_Status) {
		this.friends_Status = friends_Status;
	}

}
