package dao;

import java.util.List;

import model.Car;
import model.JoinDetail;
import model.JoinInsert;

public interface CarDAO {


	boolean insert(JoinInsert joininsert);	
	List<Car> selectAll();
	
	Car selectByCarType(int cartype);
	List<Car> selectByCarname(String carname);
	

}
