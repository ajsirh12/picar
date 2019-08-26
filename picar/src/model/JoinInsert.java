package model;

public class JoinInsert {

	private String carNum;
	private int carType;
	private int cost;
	private int carloc;
	private String carName;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCarloc() {
		return carloc;
	}
	public void setCarloc(int carloc) {
		this.carloc = carloc;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	@Override
	public String toString() {
		return "JoinInsert [carNum=" + carNum + ", carType=" + carType + ", cost=" + cost + ", carloc=" + carloc
				+ ", carName=" + carName + "]";
	}
}
