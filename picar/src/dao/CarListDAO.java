package dao;

import java.util.List;

import model.Car;
import model.CarList;

public interface CarListDAO {
	CarList selectByCarNum(String carNum);
	List<CarList> selectByNum(String carNum);
	List<CarList> selectAll();
	List<CarList> selectAll(int rowStartNumber, int rowEndNumber);
	List<CarList> selectbyCarloc(int carloc);
	List<CarList> selectByName(int carloc, String carname);
	void updateValidRent(String carNum);
	void updateCost(CarList carList);
	void deleteCarList(String carNum);
	CarList selectCarInfo(String carNum);
	CarList selectByCarloc(int carloc);
	void updateCarInfo(String carInfo, String carNum);
	void updateValidRentToN(String carNum);
}
