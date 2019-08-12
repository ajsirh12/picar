package page;

public class PageGroupResult {
	private int groupStartNumber;	//시작 페이지 
	private int groupEndNumber;		//마지막 페이지
	private boolean beforPage = true;
	private boolean afterPage = true;
	private int selectPageNumber;
	
	public int getSelectPageNumber() {
		return selectPageNumber;
	}
	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	public boolean isBeforPage() {
		return beforPage;
	}
	public void setBeforPage(boolean beforPage) {
		this.beforPage = beforPage;
	}
	public boolean isAfterPage() {
		return afterPage;
	}
	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}
	public int getGroupStartNumber() {
		return groupStartNumber;
	}
	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}
	public int getGroupEndNumber() {
		return groupEndNumber;
	}
	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}
}
