package page3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PageDAOImpl extends BaseDAO implements PageDAO{

	@Override
	public int getCount(String sql) {
		
		int count = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConection();
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				count =resultSet.getInt("cnt");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return count;
	}

}
