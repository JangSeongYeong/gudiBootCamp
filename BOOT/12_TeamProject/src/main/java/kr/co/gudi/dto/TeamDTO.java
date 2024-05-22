package kr.co.gudi.dto;

import org.apache.ibatis.type.Alias;

@Alias("team")
public class TeamDTO {
	private String team_name;
	private String project_name;
	private String team_leader;
	private String staff1;
	private String staff2;
	private String staff3;
	private String staff4;
	private String staff5;
	
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getTeam_leader() {
		return team_leader;
	}
	public void setTeam_leader(String team_leader) {
		this.team_leader = team_leader;
	}
	public String getStaff1() {
		return staff1;
	}
	public void setStaff1(String staff1) {
		this.staff1 = staff1;
	}
	public String getStaff2() {
		return staff2;
	}
	public void setStaff2(String staff2) {
		this.staff2 = staff2;
	}
	public String getStaff3() {
		return staff3;
	}
	public void setStaff3(String staff3) {
		this.staff3 = staff3;
	}
	public String getStaff4() {
		return staff4;
	}
	public void setStaff4(String staff4) {
		this.staff4 = staff4;
	}
	public String getStaff5() {
		return staff5;
	}
	public void setStaff5(String staff5) {
		this.staff5 = staff5;
	}
	
}
