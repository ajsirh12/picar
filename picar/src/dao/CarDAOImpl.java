package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.JoinInsert;

public class CarDAOImpl extends BaseDAO implements CarDAO {
	private static final String CAR_INSERT_SQL="insert into carlist values(?,?,?,?,'Y',0,null)";
	private static final String CAR_SELECT_BY_CARTYPE = "SELECT carname, fueltype, colortype, carimage FROM car WHERE cartype=?";
	private static final String CAR_SELECT_ALL = "SELECT cartype, carname, fueltype, colortype, people, carimage FROM car";	
	private static final String CAR_SELECT_CARNAME="select cartype, carname, fueltype, colortype, people, carimage from car where carname like ?";	
	
	@Override// 차량등록- 관리자
	public boolean insert(JoinInsert joininsert) {	
	
	boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_INSERT_SQL);
			
			preparedStatement.setString(1, joininsert.getCarNum());
			preparedStatement.setInt(2, joininsert.getCarType());
			preparedStatement.setInt(3, joininsert.getCost());
			preparedStatement.setInt(4, joininsert.getCarloc());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}	
		return result;
	}

	@Override
	public Car selectByCarType(int cartype) {
		Car car = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_SELECT_BY_CARTYPE);
			preparedStatement.setInt(1, cartype);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				car = new Car();
				
				car.setCarName(resultSet.getString("carname"));
				car.setFuelType(resultSet.getString("fueltype"));
				car.setColorType(resultSet.getString("colortype"));
				car.setCarImage(resultSet.getString("carimage"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return car;
	}
	@Override
	public List<Car> selectAll() {
		List<Car> carList = new ArrayList<Car>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_SELECT_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Car car = new Car();
				
				car.setCarType(resultSet.getInt("cartype"));
				car.setCarName(resultSet.getString("carname"));
				car.setFuelType(resultSet.getString("fueltype"));
				car.setColorType(resultSet.getString("colortype"));
				car.setPeople(resultSet.getInt("people"));
				car.setCarImage(resultSet.getString("carimage"));
				carList.add(car);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return carList;
	}

		//차량 검색
	@Override
	public List<Car> selectByCarname(String carname) {
		
		List<Car> cars = new ArrayList<Car>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_SELECT_CARNAME);
			preparedStatement.setString(1,'%'+carname+'%');
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Car car = new Car();
				
				car.setCarType(resultSet.getInt("cartype"));
				car.setCarName(resultSet.getString("carname"));
				car.setFuelType(resultSet.getString("fueltype"));
				car.setColorType(resultSet.getString("colortype"));
				car.setPeople(resultSet.getInt("people"));
				car.setCarImage(resultSet.getString("carimage"));
				
				cars.add(car);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}	
		return cars;
	}

}
