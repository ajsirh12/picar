package model;

public class Car {
	private int carType;
	private String carName;
	private String fuelType;
	private String colorType;
	private int People;
	private String carImage;
	public int getCarType() {
		return carType;
	}
	public void setCarType(int carType) {
		this.carType = carType;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getColorType() {
		return colorType;
	}
	public void setColorType(String colorType) {
		this.colorType = colorType;
	}
	public int getPeople() {
		return People;
	}
	public void setPeople(int people) {
		People = people;
	}
	public String getCarImage() {
		return carImage;
	}
	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}
	@Override
	public String toString() {
		return "Car [carType=" + carType + ", carName=" + carName + ", fuelType=" + fuelType + ", colorType="
				+ colorType + ", People=" + People + ", carImage=" + carImage + "]";
	}


	
}
