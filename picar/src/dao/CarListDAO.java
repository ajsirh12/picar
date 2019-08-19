package dao;

import model.CarList;

public interface CarListDAO {
	CarList selectByCarNum(String carNum);
}
