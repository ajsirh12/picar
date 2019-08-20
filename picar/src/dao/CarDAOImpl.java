package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class CarDAOImpl extends BaseDAO implements CarDAO {
	private static final String CAR_INSERT_SQL="insert into Car values(?,?,?,?,?,?)";
	private static final String CAR_LIST_SQL="select carlist.carnum,carlist.validrent,car.carname,location.location"
												+ " from car join carlist on car.cartype = carlist.cartype"
												+ " join location on carlist.carloc = location.carloc"
												+ " where location.carloc=? order by carlist.carnum";
	private static final String CAR_SELECT_BY_CARTYPE = "SELECT carname, fueltype, colortype, carimage FROM car WHERE cartype=?";
	private static final String CAR_SELECT_ALL = "SELECT cartype, carname, fueltype, colortype, people, carimage FROM car";	
	
	@Override // 차량등록- 관리자
	public boolean insert(Car car) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_INSERT_SQL);
			
			preparedStatement.setInt(1, car.getCarType());
			preparedStatement.setString(2, car.getCarName());
			preparedStatement.setString(3, car.getFuelType());
			preparedStatement.setString(4, car.getColorType());
			preparedStatement.setInt(5, car.getPeople());
			preparedStatement.setString(6, car.getCarImage());
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override //차량리스트- 보유지점별
	public Car selectByLocation(int carloc) {
		Car car = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_LIST_SQL);
			preparedStatement.setInt(1, carloc);
			resultSet = preparedStatement.executeQuery();
	
			if(resultSet.next()) {
				car = new Car();
				
				car.setCarType(resultSet.getInt("cartype"));
				car.setCarName(resultSet.getString("carname"));
				car.setFuelType(resultSet.getString("fueltype"));
				car.setColorType(resultSet.getString("colortype"));
				car.setPeople(resultSet.getInt("people"));
				car.setCarImage(resultSet.getString("carimage"));			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
			
		return car;
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
}
