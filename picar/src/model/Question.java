package model;

public class Question {
	private int questnum;
	private String questTitle;
	private String questText;
	private String questDate;
	private String answer;
	private int memberNum;
	public int getQuestnum() {
		return questnum;
	}
	public void setQuestnum(int questinum) {
		this.questnum = questinum;
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
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	@Override
	public String toString() {
		return "Question [questinum=" + questnum + ", questTitle=" + questTitle + ", questText=" + questText
				+ ", questDate=" + questDate + ", answer=" + answer + ", memberNum=" + memberNum + "]";
	}
	
	
}
