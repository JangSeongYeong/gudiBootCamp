package kr.co.gudi.dto;

import org.apache.ibatis.type.Alias;

// 하나만 넣으면 value= 생략이 가능하지만 여러가지 옵션이 들어가는게 있다면 정식 방법으로 value= 를 추가한다.
@Alias(value = "member")
public class MemberDTO {
	
	private String id;
	private String pw;
	private String name;
	private String age;
	private String gender;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
