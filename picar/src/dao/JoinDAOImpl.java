package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.JoinRent;

public class JoinDAOImpl extends BaseDAO implements JoinDAO {

	/*private static final String JOIN_SELECT_RENT_SQL = "SELECT carlist.carnum as carnum, car.carname as carname, rentinfo.totalcost as totalcost,"
			+ " car.people as people, picarmember.name as name, carlist.validrent as validrent"
			+ " FROM car, rentinfo, picarmember, carlist "
			+ "WHERE rentinfo.carnum = carlist.carnum and rentinfo.membernum = picarmember.membernum"
			+ " and carlist.cartype = car.cartype and carlist.validrent in ('n', 'N')";*/
	private static final String JOIN_SELECT_RENT_SQL = "SELECT TO_CHAR(TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(TO_CHAR(rentend, 'YYYYMMDD'))) late,"
			+ " carlist.carnum as carnum, picarmember.name as name, picarmember.phone as phone, to_char(rentinfo.rentstart,"
			+ " 'yyyy-mm-dd') as rentstart, to_char(rentinfo.rentend, 'yyyy-mm-dd') as rentend, carlist.cost as cost,"
			+ " carlist.validrent as validrent FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and"
			+ " rentinfo.membernum = picarmember.membernum and carlist.validrent in ('n', 'N')";
	private static final String JOIN_SELECT_RENT_BY_CARNUM_SQL = "SELECT carlist.carnum as carnum, car.carname as carname, rentinfo.totalcost as totalcost,"
			+ " car.people as people, picarmember.name as name, carlist.validrent as validrent"
			+ " FROM car, rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum"
			+ " and rentinfo.membernum = picarmember.membernum and carlist.cartype = car.cartype"
			+ " and carlist.validrent in ('Y', 'N') and carlist.carnum like ?";
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
				/*joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setCarName(resultSet.getString("carname"));
				joinRent.setTotalCost(resultSet.getInt("totalcost"));
				joinRent.setPeople(resultSet.getInt("people"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setValidRent(resultSet.getString("validrent"));*/
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
				/*joinRent.setCarNum(resultSet.getString("carnum"));
				joinRent.setCarName(resultSet.getString("carname"));
				joinRent.setTotalCost(resultSet.getInt("totalcost"));
				joinRent.setPeople(resultSet.getInt("people"));
				joinRent.setName(resultSet.getString("name"));
				joinRent.setValidRent(resultSet.getString("validrent"));*/
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
