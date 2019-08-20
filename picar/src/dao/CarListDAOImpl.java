package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.CarList;

public class CarListDAOImpl extends BaseDAO implements CarListDAO {

	private static final String CARLIST_SELECT_BY_CARNUM = "SELECT cartype, cost FROM carlist WHERE carnum=?";
	@Override
	public CarList selectByCarNum(String carNum) {
		CarList carList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_SELECT_BY_CARNUM);
			preparedStatement.setString(1, carNum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				carList = new CarList();
				
				carList.setCarType(resultSet.getInt("cartype"));
				carList.setCost(resultSet.getInt("cost"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return carList;
	}

}
