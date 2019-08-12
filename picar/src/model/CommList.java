package model;

public class CommList {
	private int commNum;
	private String commText;
	private String commDate;
	private int memberNum;
	private int questNum;
	public int getCommNum() {
		return commNum;
	}
	public void setCommNum(int commNum) {
		this.commNum = commNum;
	}
	public String getCommText() {
		return commText;
	}
	public void setCommText(String commText) {
		this.commText = commText;
	}
	public String getCommDate() {
		return commDate;
	}
	public void setCommDate(String commDate) {
		this.commDate = commDate;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public int getQuestNum() {
		return questNum;
	}
	public void setQuestNum(int questNum) {
		this.questNum = questNum;
	}
	@Override
	public String toString() {
		return "CommList [commNum=" + commNum + ", commText=" + commText + ", commDate=" + commDate + ", memberNum="
				+ memberNum + ", questNum=" + questNum + "]";
	}
	
	
}
