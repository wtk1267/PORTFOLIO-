package co.kr.VO;

import java.util.Date;

public class PlanVO {
	private String member_Id;
	private Integer schedule_Id;
	private String schedule_Subject;
	private String schedule_StartDate;
	private String schedule_EndDate;

	
	public PlanVO() {}


	public PlanVO(String member_Id, Integer schedule_Id, String schedule_Subject, String schedule_StartDate,
			String schedule_EndDate) {
		super();
		this.member_Id = member_Id;
		this.schedule_Id = schedule_Id;
		this.schedule_Subject = schedule_Subject;
		this.schedule_StartDate = schedule_StartDate;
		this.schedule_EndDate = schedule_EndDate;
	}


	public String getMember_Id() {
		return member_Id;
	}


	public void setMember_Id(String member_Id) {
		this.member_Id = member_Id;
	}


	public Integer getSchedule_Id() {
		return schedule_Id;
	}


	public void setSchedule_Id(Integer schedule_Id) {
		this.schedule_Id = schedule_Id;
	}


	public String getSchedule_Subject() {
		return schedule_Subject;
	}


	public void setSchedule_Subject(String schedule_Subject) {
		this.schedule_Subject = schedule_Subject;
	}


	public String getSchedule_StartDate() {
		return schedule_StartDate;
	}


	public void setSchedule_StartDate(String schedule_StartDate) {
		this.schedule_StartDate = schedule_StartDate;
	}


	public String getSchedule_EndDate() {
		return schedule_EndDate;
	}


	public void setSchedule_EndDate(String schedule_EndDate) {
		this.schedule_EndDate = schedule_EndDate;
	}
	
	
	
	
	
}
