package co.kr.VO;

import java.util.Date;

public class MessageVO {
	
	private int msg_Id;
	private String member_Id;
	private String msg_Send_Id;
	private String msg_Receive_Id;
	private String msg_Contents;
	private Date msg_Time;
	private int msg_Status;
	private String msg_Subject;
	private String rownum;
	

	
	public MessageVO() {}



	public MessageVO(int msg_Id, String member_Id, String msg_Send_Id, String msg_Receive_Id, String msg_Contents,
			Date msg_Time, int msg_Status, String msg_Subject, String rownum) {
		super();
		this.msg_Id = msg_Id;
		this.member_Id = member_Id;
		this.msg_Send_Id = msg_Send_Id;
		this.msg_Receive_Id = msg_Receive_Id;
		this.msg_Contents = msg_Contents;
		this.msg_Time = msg_Time;
		this.msg_Status = msg_Status;
		this.msg_Subject = msg_Subject;
		this.rownum = rownum;
	}



	public int getMsg_Id() {
		return msg_Id;
	}



	public void setMsg_Id(int msg_Id) {
		this.msg_Id = msg_Id;
	}



	public String getMember_Id() {
		return member_Id;
	}



	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}



	public String getMsg_Send_Id() {
		return msg_Send_Id;
	}



	public void setMsg_Send_Id(String msg_Send_Id) {
		this.msg_Send_Id = msg_Send_Id;
	}



	public String getMsg_Receive_Id() {
		return msg_Receive_Id;
	}



	public void setMsg_Receive_Id(String msg_Receive_Id) {
		this.msg_Receive_Id = msg_Receive_Id;
	}



	public String getMsg_Contents() {
		return msg_Contents;
	}



	public void setMsg_Contents(String msg_Contents) {
		this.msg_Contents = msg_Contents;
	}



	public Date getMsg_Time() {
		return msg_Time;
	}



	public void setMsg_Time(Date msg_Time) {
		this.msg_Time = msg_Time;
	}



	public int getMsg_Status() {
		return msg_Status;
	}



	public void setMsg_Status(int msg_Status) {
		this.msg_Status = msg_Status;
	}



	public String getMsg_Subject() {
		return msg_Subject;
	}



	public void setMsg_Subject(String msg_Subject) {
		this.msg_Subject = msg_Subject;
	}



	public String getRownum() {
		return rownum;
	}



	public void setRownum(String rownum) {
		this.rownum = rownum;
	}
	
	
}
