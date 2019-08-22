package dao;

import model.Car;
import model.JoinInsert;

public interface CarDAO {


	boolean insert(JoinInsert joininsert);	

	boolean insert(Car car);
	
	Car selectByLocation(int carloc);
	Car selectByCarType(int cartype);

}
