package model;

public class PicarMember {
	private int memberNum;
	private String id;
	private String password;
	private String name;
	private String phone;
	private int license;
	private String validate;
	private int gradeNo;
	
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLicense() {
		return license;
	}
	public void setLicense(int license) {
		this.license = license;
	}
	public String getValidate() {
		return validate;
	}
	public void setValidate(String validate) {
		this.validate = validate;
	}
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	@Override
	public String toString() {
		return "PicarMember [memberNum=" + memberNum + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", license=" + license + ", validate=" + validate + ", gradeNo=" + gradeNo + "]";
	}
	
}
