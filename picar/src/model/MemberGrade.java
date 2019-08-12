package model;

public class MemberGrade {
	private int gradeNo;
	private String memberGrade;
	public int getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	@Override
	public String toString() {
		return "MemberGrade [gradeNo=" + gradeNo + ", memberGrade=" + memberGrade + "]";
	}
	
}
