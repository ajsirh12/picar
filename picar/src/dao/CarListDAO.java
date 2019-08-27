package dao;

import java.util.List;

import model.CarList;
import model.Location;

public interface CarListDAO {
	CarList selectByCarNum(String carNum);
	List<CarList> selectByNum(String carNum);
	List<CarList> selectAll();
	List<CarList> selectAll(int rowStartNumber, int rowEndNumber);
	List<CarList> selectbyCarloc(int carloc);
	void updateValidRent(String carNum);
	void updateCost(CarList carList);
	void deleteCarList(String carNum);
	CarList selectCarInfo(String carNum);
	CarList selectByCarloc(int carloc);
}
