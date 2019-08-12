package page;

public class PageRowResult {
	private int rowStartNumber;	//페이지에 보여줄 ROWNUM 첫번째 글
	private int rowEndNumber;	//ROWNUM 마지막 글
	
	public int getRowStartNumber() {
		return rowStartNumber;
	}
	public void setRowStartNumber(int rowStartNumber) {
		this.rowStartNumber = rowStartNumber;
	}
	public int getRowEndNumber() {
		return rowEndNumber;
	}
	public void setRowEndNumber(int rowEndNumber) {
		this.rowEndNumber = rowEndNumber;
	}
}
