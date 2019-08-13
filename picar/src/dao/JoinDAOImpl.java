package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.JoinRent;

public class JoinDAOImpl extends BaseDAO implements JoinDAO {

	private static final String JOIN_SELECT_RENT_SQL = "SELECT TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(TO_CHAR(rentend, 'YYYYMMDD'))) late,"
			+ " carlist.carnum as carnum, picarmember.name as name, picarmember.phone as phone, to_char(rentinfo.rentstart,"
			+ " 'yyyy-mm-dd') as rentstart, to_char(rentinfo.rentend, 'yyyy-mm-dd') as rentend, carlist.cost as cost,"
			+ " carlist.validrent as validrent FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and"
			+ " rentinfo.membernum = picarmember.membernum and carlist.validrent in ('n', 'N')";
	private static final String JOIN_SELECT_RENT_BY_CARNUM_SQL = "SELECT TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(TO_CHAR(rentend, 'YYYYMMDD'))) late, carlist.carnum as carnum, picarmember.name as name, picarmember.phone as phone, to_char(rentinfo.rentstart, 'yyyy-mm-dd') as rentstart, to_char(rentinfo.rentend, 'yyyy-mm-dd') as rentend, carlist.cost as cost, carlist.validrent as validrent FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and rentinfo.membernum = picarmember.membernum and carlist.validrent in ('n', 'N') and carlist.carnum like ?";
	private static final String JOIN_SELECT_RENT_PAGE_SQL = "SELECT * FROM (SELECT rownum rn, rented.* FROM (SELECT TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(TO_CHAR(rentend, 'YYYYMMDD'))) late, carlist.carnum as carnum, picarmember.name as name, picarmember.phone as phone, to_char(rentinfo.rentstart, 'yyyy-mm-dd') as rentstart, to_char(rentinfo.rentend, 'yyyy-mm-dd') as rentend, carlist.cost as cost, carlist.validrent as validrent FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and rentinfo.membernum = picarmember.membernum and carlist.validrent in ('n', 'N') ORDER BY late desc) rented) WHERE rn between ? and ?";
	private static final String JOIN_SELECT_RENT_BY_CARNUM_PAGE_SQL = "SELECT rownum rn, TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(TO_CHAR(rentend, 'YYYYMMDD'))) late, carlist.carnum as carnum, picarmember.name as name, picarmember.phone as phone, to_char(rentinfo.rentstart, 'yyyy-mm-dd') as rentstart, to_char(rentinfo.rentend, 'yyyy-mm-dd') as rentend, carlist.cost as cost, carlist.validrent as validrent FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and rentinfo.membernum = picarmember.membernum and rownum between ? and ? and carlist.validrent in ('n', 'N') and carlist.carnum like ? ORDER BY late desc"; 
	@Override
	public List<JoinRent> selectJoin() {
		List<JoinRent> joinRentList = new ArrayList<JoinRent>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(JOIN_SELECT_RENT_SQL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				JoinRent joinRent = new JoinRent();
				joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setPhone(resultSet.getString("phone"));
				joinRent.setRentStart(resultSet.getString("rentstart"));
				joinRent.setRentEnd(resultSet.getString("rentend"));
				joinRent.setCost(resultSet.getInt("cost"));
				joinRent.setLate(resultSet.getInt("late"));
				joinRent.setValidRent(resultSet.getString("validrent"));
				joinRentList.add(joinRent);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return joinRentList;
	}
	@Override
	public List<JoinRent> selectJoinBycarNum(String carNum) {
		List<JoinRent> joinRentList = new ArrayList<JoinRent>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(JOIN_SELECT_RENT_BY_CARNUM_SQL);
			preparedStatement.setString(1, "%"+carNum+"%");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				JoinRent joinRent = new JoinRent();
				joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setPhone(resultSet.getString("phone"));
				joinRent.setRentStart(resultSet.getString("rentstart"));
				joinRent.setRentEnd(resultSet.getString("rentend"));
				joinRent.setCost(resultSet.getInt("cost"));
				joinRent.setLate(resultSet.getInt("late"));
				joinRent.setValidRent(resultSet.getString("validrent"));
				joinRentList.add(joinRent);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return joinRentList;
	}
	@Override
	public List<JoinRent> selectJoin(int rowStartNumber, int rowEndNumber) {
		List<JoinRent> joinRentList = new ArrayList<JoinRent>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(JOIN_SELECT_RENT_PAGE_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				JoinRent joinRent = new JoinRent();
				joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setPhone(resultSet.getString("phone"));
				joinRent.setRentStart(resultSet.getString("rentstart"));
				joinRent.setRentEnd(resultSet.getString("rentend"));
				joinRent.setCost(resultSet.getInt("cost"));
				joinRent.setLate(resultSet.getInt("late"));
				joinRent.setValidRent(resultSet.getString("validrent"));
				joinRentList.add(joinRent);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return joinRentList;
	}
	@Override
	public List<JoinRent> selectJoinBycarNum(int rowStartNumber, int rowEndNumber, String carNum) {
List<JoinRent> joinRentList = new ArrayList<JoinRent>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(JOIN_SELECT_RENT_BY_CARNUM_PAGE_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			preparedStatement.setString(3, "%"+carNum+"%");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				JoinRent joinRent = new JoinRent();
				joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setPhone(resultSet.getString("phone"));
				joinRent.setRentStart(resultSet.getString("rentstart"));
				joinRent.setRentEnd(resultSet.getString("rentend"));
				joinRent.setCost(resultSet.getInt("cost"));
				joinRent.setLate(resultSet.getInt("late"));
				joinRent.setValidRent(resultSet.getString("validrent"));
				joinRentList.add(joinRent);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return joinRentList;
	}
	
}
