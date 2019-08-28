package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import model.RentInfo;

public class RentInfoDAOImpl extends BaseDAO implements RentInfoDAO {
	private static final String RENTINFO_SELECT_DATE_BY_MEMBERNUM = "SELECT rentnum, to_char(rentstart, 'yyyy/mm/dd') rentstart, to_char(rentend, 'yyyy/mm/dd') rentend, membernum, carnum FROM rentinfo WHERE membernum = ?";
	private static final String RENTINFO_UPDATE_RENTEND_BY_RENTNUM = "UPDATE rentinfo SET rentend = rentend + ? WHERE rentnum = ?";
	private static final String RENTINFO_DELETE_BY_CARNUM = "DELETE FROM rentinfo WHERE carnum = ?";
	private static final String RENTINFO_INSERT_INTO = "INSERT INTO rentinfo values(SEQ_RENTNUM.nextval, ?, ?, ?, ?)";
	@Override
	public RentInfo selectByMemberNum(int memberNum) {
		RentInfo rentInfo = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(RENTINFO_SELECT_DATE_BY_MEMBERNUM);
			preparedStatement.setInt(1, memberNum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				rentInfo = new RentInfo();
				
				rentInfo.setRentNum(resultSet.getInt("rentnum"));
				rentInfo.setRentStart(resultSet.getString("rentstart"));
				rentInfo.setRentEnd(resultSet.getString("rentend"));
				rentInfo.setMemberNum(resultSet.getInt("membernum"));
				rentInfo.setCarNum(resultSet.getString("carnum"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return rentInfo;
	}
	@Override
	public void renewByRentNum(int renew, int rentNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(RENTINFO_UPDATE_RENTEND_BY_RENTNUM);
			preparedStatement.setInt(1, renew);
			preparedStatement.setInt(2, rentNum);
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
	public void deleteByCarNum(String carNum) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(RENTINFO_DELETE_BY_CARNUM);
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
	public void insertRentInfo(RentInfo rentinfo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(RENTINFO_INSERT_INTO);
			preparedStatement.setString(1, rentinfo.getRentStart());
			preparedStatement.setString(2, rentinfo.getRentEnd());
			preparedStatement.setInt(3, rentinfo.getMemberNum());
			preparedStatement.setString(4, rentinfo.getCarNum());
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
