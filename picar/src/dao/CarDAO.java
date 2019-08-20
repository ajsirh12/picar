package dao;

import model.JoinInsert;

public interface CarDAO {

<<<<<<< HEAD
	boolean insert(JoinInsert joininsert);	
=======
	boolean insert(Car car);
	
	Car selectByLocation(int carloc);
	Car selectByCarType(int cartype);
	
>>>>>>> branch 'master' of https://github.com/ajsirh12/picar
}
