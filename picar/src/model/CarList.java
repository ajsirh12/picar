package model;

public class CarList {
	private String carnum;
	private int carType;
	private int cost;
	private int carLoc;
	private String validRent;
	private int driveRange;
	private int usedTime;
	private String carInfo;
	private String carName;
	
	public String getCarInfo() {
		return carInfo;
	}
	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
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
	public int getCarLoc() {
		return carLoc;
	}
	public void setCarLoc(int carLoc) {
		this.carLoc = carLoc;
	}
	public String getValidRent() {
		return validRent;
	}
	public void setValidRent(String validRent) {
		this.validRent = validRent;
	}
	public int getDriveRange() {
		return driveRange;
	}
	public void setDriveRange(int driveRange) {
		this.driveRange = driveRange;
	}
	public int getUsedTime() {
		return usedTime;
	}
	public void setUsedTime(int usedTime) {
		this.usedTime = usedTime;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "CarList [carnum=" + carnum + ", carType=" + carType + ", cost=" + cost + ", carLoc=" + carLoc
				+ ", validRent=" + validRent + ", driveRange=" + driveRange + ", usedTime=" + usedTime + ", carInfo="
				+ carInfo + ", carName=" + carName + "]";
	}
	
	
		
}
