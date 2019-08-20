package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Location;

public class LocationDAOImpl extends BaseDAO implements LocationDAO {
	
	private static final String LOCATION_ALL_SQL="select * from location";

	@Override
	public List<Location> selectAll() {
		
		List<Location> list = new ArrayList<Location>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(LOCATION_ALL_SQL);
			resultSet = preparedStatement.executeQuery();	
			
			
			while(resultSet.next()) {
				
				Location loc = new Location();
				
				loc.setCarLoc(resultSet.getInt("carloc"));
				loc.setLocation(resultSet.getString("location"));
				
				list.add(loc);	
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return list;
	}
}
