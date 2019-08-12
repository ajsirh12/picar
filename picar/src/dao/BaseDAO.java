package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "PICAR";
	public static final String PASSWORD = "PICAR";
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		catch(ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		
		return connection;
	}
	
	public void closeDBObjects(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null)
		{
			try {
				connection.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
	}
}
