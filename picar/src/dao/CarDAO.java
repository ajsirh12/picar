package dao;

import java.util.List;

import model.Car;

public interface CarDAO {

	boolean insert(Car car);
	List<Car> selectAll();
	Car selectByLocation(int carloc);
	Car selectByCarType(int cartype);
	
}
