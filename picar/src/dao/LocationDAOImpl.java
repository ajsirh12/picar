package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import model.Location;

public class LocationDAOImpl extends BaseDAO implements LocationDAO {
	private static final String LOCATION_SELECT_ALL = "SELECT carloc, location FROM location";
	
	@Override
	public List<Location> selectAll() {
		List<Location> locationList = new ArrayList<Location>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(LOCATION_SELECT_ALL);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Location location = new Location();
				
				location.setCarLoc(resultSet.getInt("carloc"));
				location.setLocation(resultSet.getString("location"));
				locationList.add(location);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return locationList;
	}
	
}
