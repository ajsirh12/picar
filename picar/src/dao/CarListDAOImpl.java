package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CarList;

public class CarListDAOImpl extends BaseDAO implements CarListDAO {

	private static final String CARLIST_SELECT_BY_CARNUM = "SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist WHERE carnum=?";
	private static final String CARLIST_SELECT_ALL = "SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist";
	private static final String CARLIST_SELECT_ALL_PAGE = "SELECT * FROM (SELECT rownum rn, carlist.* FROM (SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist ) carlist) WHERE rn between ? and ?";
	private static final String CARLIST_UPDATE_VALIDRENT_BY_CARNUM = "UPDATE carlist SET validrent = 'Y' WHERE carnum = ?";
	private static final String CARLIST_UPDATE_COST_VALID_BY_CARNUM = "UPDATE carlist SET cost = ?, validrent = ?, carloc = ? WHERE carnum = ?";
	private static final String CARLIST_DELETE_BY_CARNUM = "DELETE FROM carlist WHERE carnum = ?";
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
				
				carList.setCarnum(resultSet.getString("carnum"));
				carList.setCarType(resultSet.getInt("cartype"));
				carList.setCost(resultSet.getInt("cost"));
				carList.setCarLoc(resultSet.getInt("carloc"));
				carList.setValidRent(resultSet.getString("validrent"));
				carList.setUsedTime(resultSet.getInt("usedtime"));
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
	@Override
	public List<CarList> selectAll() {
		List<CarList> carListList = new ArrayList<CarList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_SELECT_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				CarList carList = new CarList();
				
				carList.setCarnum(resultSet.getString("carnum"));
				carList.setCarType(resultSet.getInt("cartype"));
				carList.setCost(resultSet.getInt("cost"));
				carList.setCarLoc(resultSet.getInt("carloc"));
				carList.setValidRent(resultSet.getString("validrent"));
				carList.setUsedTime(resultSet.getInt("usedtime"));
				carListList.add(carList);
			}
		}
		catch(SQLException e) {
			
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return carListList;
	}
	@Override
	public List<CarList> selectAll(int rowStartNumber, int rowEndNumber) {
		List<CarList> carListList = new ArrayList<CarList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_SELECT_ALL_PAGE);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				CarList carList = new CarList();
				
				carList.setCarnum(resultSet.getString("carnum"));
				carList.setCarType(resultSet.getInt("cartype"));
				carList.setCost(resultSet.getInt("cost"));
				carList.setCarLoc(resultSet.getInt("carloc"));
				carList.setValidRent(resultSet.getString("validrent"));
				carList.setUsedTime(resultSet.getInt("usedtime"));
				carListList.add(carList);
			}
		}
		catch(SQLException e) {
			
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return carListList;
	}
	@Override
	public void updateValidRent(String carNum) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_UPDATE_VALIDRENT_BY_CARNUM);
			preparedStatement.setString(1, carNum);
			preparedStatement.execute();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
	}
	@Override
	public void updateCost(CarList carList) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_UPDATE_COST_VALID_BY_CARNUM);
			preparedStatement.setInt(1, carList.getCost());
			preparedStatement.setString(2, carList.getValidRent());
			preparedStatement.setInt(3, carList.getCarLoc());
			preparedStatement.setString(4, carList.getCarnum());
			preparedStatement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
	}
	@Override
	public void deleteCarList(String carNum) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_DELETE_BY_CARNUM);
			preparedStatement.setString(1, carNum);
			preparedStatement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
	}

}
