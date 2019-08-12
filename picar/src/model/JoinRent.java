package model;

public class JoinRent {
	private String carNum;
	private String carName;
	private int totalCost;
	private int people;
	private String name;
	private String validRent;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValidRent() {
		return validRent;
	}
	public void setValidRent(String validRent) {
		this.validRent = validRent;
	}
	@Override
	public String toString() {
		return "JoinRent [carNum=" + carNum + ", carName=" + carName + ", totalCost=" + totalCost + ", people=" + people
				+ ", name=" + name + ", validRent=" + validRent + "]";
	}
	
	
}
