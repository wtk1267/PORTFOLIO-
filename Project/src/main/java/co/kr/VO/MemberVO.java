package co.kr.VO;

public class MemberVO {
	
	private String member_Id;
	private String member_Name;
	private String member_Password;
	private String member_Email;
	private String member_Interesting;
	private int member_OpenInfo;
	private String member_Image;
	private int member_Status;
	
	
	public MemberVO() {}



	public MemberVO(String member_Id, String member_Name, String member_Password, String member_Email,
			String member_Interesting, int member_OpneInfo, String member_Image, int member_Status) {
		this.member_Id = member_Id;
		this.member_Name = member_Name;
		this.member_Password = member_Password;
		this.member_Email = member_Email;
		this.member_Interesting = member_Interesting;
		this.member_OpenInfo = member_OpneInfo;
		this.member_Image = member_Image;
		this.member_Status = member_Status;
	}



	public String getMember_Id() {
		return member_Id;
	}



	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}



	public String getMember_Name() {
		return member_Name;
	}



	public void setMember_Name(String member_Name) {
		this.member_Name = member_Name;
	}



	public String getMember_Password() {
		return member_Password;
	}



	public void setMember_Password(String member_Password) {
		this.member_Password = member_Password;
	}



	public String getMember_Email() {
		return member_Email;
	}



	public void setMember_Email(String member_Email) {
		this.member_Email = member_Email;
	}



	public String getMember_Interesting() {
		return member_Interesting;
	}



	public void setMember_Interesting(String member_Interesting) {
		this.member_Interesting = member_Interesting;
	}



	public int getMember_OpenInfo() {
		return member_OpenInfo;
	}



	public void setMember_OpenInfo(int member_OpneInfo) {
		this.member_OpenInfo = member_OpneInfo;
	}



	public String getMember_Image() {
		return member_Image;
	}



	public void setMember_Image(String member_Image) {
		this.member_Image = member_Image;
	}



	public int getMember_Status() {
		return member_Status;
	}



	public void setMember_Status(int member_Status) {
		this.member_Status = member_Status;
	}
	
	
	
	
	
}
