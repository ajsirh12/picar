package page3;

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
	
	public Connection getConection() {
		Connection connection = null;
		
		try {
			Class.forName(DRIVER);
			
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(SQLException ex01) {
			ex01.printStackTrace();
		}
		catch(ClassNotFoundException ex02) {
			ex02.printStackTrace();
		}
		return connection;
	}
	
	public void closeDBObject(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet !=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement !=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection !=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
