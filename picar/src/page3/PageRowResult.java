package page3;

public class PageRowResult {
	
	private int rowStartNumber;//한페이지에 출력되는 ROWNUM 시작 값
	private int rowEndNumber;//한페이지에 출력되는 ROWNUM 마지막 값
	
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
