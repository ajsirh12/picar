package dao;

import java.util.List;

import model.Car;
import model.JoinInsert;

public interface CarDAO {


	boolean insert(JoinInsert joininsert);	

	boolean insert(Car car);
	List<Car> selectAll();
	Car selectByLocation(int carloc);
	Car selectByCarType(int cartype);

}
