package model;

public class JoinRent {
	private String carNum;
	private String carName;
	private int totalCost;
	private int people;
	private String name;
	private String validRent;
	private String rentStart;
	private String rentEnd;
	private int late;
	private int cost;
	private String phone;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRentStart() {
		return rentStart;
	}
	public void setRentStart(String rentStart) {
		this.rentStart = rentStart;
	}
	public String getRentEnd() {
		return rentEnd;
	}
	public void setRentEnd(String rentEnd) {
		this.rentEnd = rentEnd;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
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
		return "JoinRent [carNum=" + carNum + ", carName=" + carName + ", name=" + name + ", validRent=" + validRent
				+ ", rentStart=" + rentStart + ", rentEnd=" + rentEnd + ", late=" + late + ", cost=" + cost + "]";
	}
	
	
}
