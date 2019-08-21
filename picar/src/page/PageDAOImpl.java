package page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BaseDAO;

public class PageDAOImpl extends BaseDAO implements PageDAO {
	
	@Override
	public int getCount(String sql) {
		int count = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			System.out.println("bananaaa");
			if(resultSet.next()) {
				count = resultSet.getInt("cnt");
			}
		}
		catch(SQLException e) {
			
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return count;
	}

	@Override
	public int getCount(String sql, String str) {
		int count = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%"+str+"%");
			resultSet = preparedStatement.executeQuery();
			System.out.println("banana");
			System.out.println(sql + str);
			if(resultSet.next()) {
				count = resultSet.getInt("cnt");
			}
		}
		catch(SQLException e) {
			
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return count;
	}

}
