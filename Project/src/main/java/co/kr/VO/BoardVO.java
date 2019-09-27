package co.kr.VO;

import java.util.Date;

public class BoardVO {
	
	private String member_Id;
	private String board_Id;
	private Integer board_No; 
	private String board_Status;
	private String board_Subject;
	private String board_Contents;
	private Date board_Time;
	private String board_Ip;
	private Integer board_Hit;
	private String rownum;
	
	
	public String getRownum() {
		return rownum;
	}


	public void setRownum(String rownum) {
		this.rownum = rownum;
	}


	public BoardVO() {}


	public BoardVO(String member_Id, String board_Id, Integer board_No, String board_Status, String board_Subject,
			String board_Contents, Date board_Time, String board_Ip, Integer board_Hit, String rownum
			) {
		this.member_Id = member_Id;
		this.board_Id = board_Id;
		this.board_No = board_No;
		this.board_Status = board_Status;
		this.board_Subject = board_Subject;
		this.board_Contents = board_Contents;
		this.board_Time = board_Time;
		this.board_Ip = board_Ip;
		this.board_Hit = board_Hit;
	}


	public String getMember_Id() {
		return member_Id;
	}


	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}


	public String getBoard_Id() {
		return board_Id;
	}


	public void setBoard_Id(String board_Id) {
		this.board_Id = board_Id;
	}


	public Integer getBoard_No() {
		return board_No;
	}


	public void setBoard_No(Integer board_No) {
		this.board_No = board_No;
	}


	public String getBoard_Status() {
		return board_Status;
	}


	public void setBoard_Status(String board_Status) {
		this.board_Status = board_Status;
	}


	public String getBoard_Subject() {
		return board_Subject;
	}


	public void setBoard_Subject(String board_Subject) {
		this.board_Subject = board_Subject;
	}


	public String getBoard_Contents() {
		return board_Contents;
	}


	public void setBoard_Contents(String board_Contents) {
		this.board_Contents = board_Contents;
	}


	public Date getBoard_Time() {
		return board_Time;
	}


	public void setBoard_Time(Date board_Time) {
		this.board_Time = board_Time;
	}


	public String getBoard_Ip() {
		return board_Ip;
	}


	public void setBoard_Ip(String board_Ip) {
		this.board_Ip = board_Ip;
	}


	public Integer getBoard_Hit() {
		return board_Hit;
	}


	public void setBoard_Hit(Integer board_Hit) {
		this.board_Hit = board_Hit;
	}

	
	
}
