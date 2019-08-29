package model;

public class Location {
	private int carLoc;
	private String location;
	
	public int getCarLoc() {
		return carLoc;
	}
	public void setCarLoc(int carLoc) {
		this.carLoc = carLoc;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Location [carLoc=" + carLoc + ", location=" + location + "]";
	}
}
