package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.JoinDetail;

public class JoinDetailDAOImpl extends BaseDAO implements JoinDetailDAO {
	
	private static final String CAR_DETAIL_SQL="select carnum, carname, location.location, carlist.cost, people, fueltype from car join carlist on car.cartype = carlist.cartype join location on carlist.carloc = location.carloc where carlist.carnum=?";

	@Override
	public JoinDetail selectByCarNum(String carnum) {
		JoinDetail detail = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_DETAIL_SQL);
			preparedStatement.setString(1, carnum);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				detail = new JoinDetail();
				
				detail.setCarnum(resultSet.getString("carnum"));
				detail.setCarname(resultSet.getString("carname"));
				detail.setLocation(resultSet.getString("location"));
				detail.setCost(resultSet.getInt("cost"));
				detail.setPeople(resultSet.getInt("people"));
				detail.setFueltype(resultSet.getString("fueltype"));	
				
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}		
		return detail;
	}

	
}
