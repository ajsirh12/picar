package dao;

import java.util.List;

import model.Car;
import model.JoinInsert;

public interface CarDAO {


	boolean insert(JoinInsert joininsert);	
	List<Car> selectAll();
	
	Car selectByCarType(int cartype);

}
