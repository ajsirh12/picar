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
	private static final String CARLIST_SELECT_BY_NUM = "SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist WHERE carnum like ?";
	private static final String CARLIST_SELECT_ALL = "SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist";
	private static final String CARLIST_SELECT_ALL_PAGE = "SELECT * FROM (SELECT rownum rn, carlist.* FROM (SELECT carnum, cartype, cost, carloc, validrent, usedtime FROM carlist ) carlist) WHERE rn between ? and ?";
	private static final String CARLIST_UPDATE_VALIDRENT_BY_CARNUM = "UPDATE carlist SET validrent = 'Y' WHERE carnum = ?";
	private static final String CARLIST_UPDATE_COST_VALID_BY_CARNUM = "UPDATE carlist SET cost = ?, validrent = ?, carloc = ? WHERE carnum = ?";
	private static final String CARLIST_DELETE_BY_CARNUM = "DELETE FROM carlist WHERE carnum = ?";
	private static final String CARLIST_SELECT_CARINFO = "SELECT carnum, carinfo FROM carlist WHERE carnum = ?";
	private static final String CARLIST_SELECT_CARLOC = "select carlist.carnum, car.carname, carlist.carloc, carlist.validrent, location.location from carlist join car on carlist.cartype = car.cartype join location on carlist.carloc = location.carloc where carlist.carloc=? and validrent in ('Y','y')"; 
	private static final String CARLIST_UPDATE_CARINFO_BY_CARNUM = "UPDATE carlist set carinfo = ? WHERE carnum = ?";
	private static final String CARLIST_UPDATE_VALIDRENT_TO_N = "UPDATE carlist SET validrent = 'N' WHERE carnum=?";
	private static final String CAR_SELECT_CARNAME="select carlist.carnum, car.carname, carlist.validrent, location.location from carlist join car on carlist.cartype = car.cartype join location on carlist.carloc = location.carloc where location.carloc=? and car.carname like ?";
	private static final String CARLIST_SELECT_ALL_COUNT="SELECT * FROM (SELECT ROWNUM RN, cars.* "
														+ "	FROM (SELECT LOCATION,CARNUM, CARNAME, VALIDRENT as carlists FROM location,car,carlist WHERE car.cartype=carlist.cartype and carlist.carloc=location.carloc and location.carloc=?) cars)"
														+ " WHERE RN BETWEEN ? and ?";
	
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
	@Override
	public List<CarList> selectByNum(String carNum) {
		List<CarList> carListList = new ArrayList<CarList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_SELECT_BY_NUM);
			preparedStatement.setString(1, "%"+carNum+"%");
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
			e.printStackTrace();
		}
		finally{
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return carListList;
	}
	@Override
	public CarList selectCarInfo(String carNum) {
		CarList carList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_SELECT_CARINFO);
			preparedStatement.setString(1, carNum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				carList = new CarList();
				
				carList.setCarnum(resultSet.getString("carnum"));
				carList.setCarInfo(resultSet.getString("carinfo"));
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
	
	//보유지점 리스트
	@Override
	public CarList selectByCarloc(int carloc) {
		CarList carlist = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(CARLIST_SELECT_CARLOC);
				preparedStatement.setInt(1, carloc);
				resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next()) {
					carlist = new CarList();
					
					carlist.setCarnum(resultSet.getString("carnum"));
					carlist.setCarName(resultSet.getString("carname"));
					carlist.setValidRent(resultSet.getString("validrent"));
					carlist.setCarLoc(resultSet.getInt("carloc"));					
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement, connection);
			}			
			return carlist;
		}
	
	@Override
	public List<CarList> selectbyCarloc(int carloc) {
		List<CarList> carListList = new ArrayList<CarList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(CARLIST_SELECT_CARLOC);
				preparedStatement.setInt(1, carloc);
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					CarList carList = new CarList();
					
					carList.setCarnum(resultSet.getString("carnum"));
					carList.setCarName(resultSet.getString("carname"));
					carList.setValidRent(resultSet.getString("validrent"));
					carList.setCarLoc(resultSet.getInt("carloc"));
					carList.setLocation(resultSet.getString("location"));
					
					carListList.add(carList);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement, connection);
			}			
			return carListList;
		}
	@Override
	public void updateCarInfo(String carInfo, String carNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_UPDATE_CARINFO_BY_CARNUM);
			preparedStatement.setString(1, carInfo);
			preparedStatement.setString(2, carNum);
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
	public void updateValidRentToN(String carNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CARLIST_UPDATE_VALIDRENT_TO_N);
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
	
	//차량검색
		@Override
		public List<CarList> selectByName(int carloc, String carname) {
			List<CarList> carlist = new ArrayList<CarList>();
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(CAR_SELECT_CARNAME);
				preparedStatement.setInt(1, carloc);
				preparedStatement.setString(2,"%"+carname+"%");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					CarList carlists = new CarList();
					
					carlists.setCarnum(resultSet.getString("carnum"));
					carlists.setCarName(resultSet.getString("carname"));
					carlists.setValidRent(resultSet.getString("validrent"));
					carlists.setLocation(resultSet.getString("location"));
					
					carlist.add(carlists);
				}			
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				closeDBObjects(resultSet, preparedStatement, connection);
			}	
			return carlist;
		}
	
}
