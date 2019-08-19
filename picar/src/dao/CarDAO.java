package dao;

import model.Car;

public interface CarDAO {

	boolean insert(Car car);
	
	Car selectByLocation(int carloc);
	Car selectByCarType(int cartype);
	
}
