package model;

public class RentInfo {
	private int rentNum;
	private String rentStart;
	private int rentTime;
	private String rentEnd;
	private int totalCost;
	private int memberNum;
	private String carNum;
	public int getRentNum() {
		return rentNum;
	}
	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}
	public String getRentStart() {
		return rentStart;
	}
	public void setRentStart(String rentStart) {
		this.rentStart = rentStart;
	}
	public int getRentTime() {
		return rentTime;
	}
	public void setRentTime(int rentTime) {
		this.rentTime = rentTime;
	}
	public String getRentEnd() {
		return rentEnd;
	}
	public void setRentEnd(String rentEnd) {
		this.rentEnd = rentEnd;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	@Override
	public String toString() {
		return "RentInfo [rentNum=" + rentNum + ", rentStart=" + rentStart + ", rentTime=" + rentTime + ", rentEnd="
				+ rentEnd + ", totalCost=" + totalCost + ", memberNum=" + memberNum + ", carNum=" + carNum + "]";
	}
	
	
}
