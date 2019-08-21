package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;

import model.CommList;

public class CommListDAOImpl extends BaseDAO implements CommListDAO {
	
	private static final String COMMLIST_INSERT_SQL
	="INSERT INTO COMMLIST"
			+ " VALUES(SEQ_COMMNUM.NEXTVAL,?,SYSDATE,?,?)";
	
	private static final String COMMLIST_SELECT_BY_QUESNUM_SQL
	="SELECT *"
			+ " FROM COMMLIST"
			+ " WHERE QUESTNUM=?";
	
	private static final String COMMLIST_UPDATE_SQL
	="UPDATE COMMLIST"
			+ " SET COMMTEXT=?"
			+ " WHERE QUESTNUM=?";

	@Override
	public boolean insert(CommList commList) {
		
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMLIST_INSERT_SQL);
			
			preparedStatement.setString(1, commList.getCommText());
			preparedStatement.setInt(2, commList.getMemberNum());
			preparedStatement.setInt(3, commList.getQuestnum());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
		}

	@Override
	public CommList selectByQuestnum(int questnum) {
		
		CommList commList = new CommList();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMLIST_SELECT_BY_QUESNUM_SQL);
			preparedStatement.setInt(1, questnum);
			
			resultSet = preparedStatement.executeQuery();
			
		if(resultSet.next()) {
			
			commList.setCommNum(resultSet.getInt("commNum"));
			commList.setCommText(resultSet.getString("commText"));
			commList.setCommDate(resultSet.getString("commDate"));
			commList.setMemberNum(resultSet.getInt("memberNum"));
			commList.setQuestnum(resultSet.getInt("questnum"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return commList;
	}

	@Override
	public boolean update(CommList commmList) {
		
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMLIST_UPDATE_SQL);
			
			preparedStatement.setString(1, commmList.getCommText());
			preparedStatement.setInt(2, commmList.getQuestnum());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}
}
