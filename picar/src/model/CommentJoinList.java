package model;

public class CommentJoinList {
	
	private int memberNum;
	private String id;
	private int questnum;
	private String questTitle;
	private String questText;
	private String questDate;
	private String answer;
	
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
	public int getQuestnum() {
		return questnum;
	}
	public void setQuestnum(int questnum) {
		this.questnum = questnum;
	}
	public String getQuestTitle() {
		return questTitle;
	}
	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}
	public String getQuestText() {
		return questText;
	}
	public void setQuestText(String questText) {
		this.questText = questText;
	}
	public String getQuestDate() {
		return questDate;
	}
	public void setQuestDate(String questDate) {
		this.questDate = questDate;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public String toString() {
		return "Commentlist [memberNum=" + memberNum + ", id=" + id + ", questnum=" + questnum + ", questTitle="
				+ questTitle + ", questText=" + questText + ", questDate=" + questDate + ", answer=" + answer + "]";
	}
}
