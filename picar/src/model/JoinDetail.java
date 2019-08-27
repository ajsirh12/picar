package model;

public class JoinDetail {
	
	private String carnum;
	private String carname;
	private String location;
	private int cost;
	private int people;
	private String fueltype;
	
	public String getCarnum() {
		return carnum;
	}
	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	
	@Override
	public String toString() {
		return "JoinDetail [carnum=" + carnum + ", carname=" + carname + ", location=" + location + ", cost=" + cost
				+ ", people=" + people + ", fueltype=" + fueltype + "]";
	}
   
}
