package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.impl.orb.PrefixParserAction;

import model.Car;
import model.JoinInsert;
import model.Location;

public class CarDAOImpl extends BaseDAO implements CarDAO {
	private static final String CAR_INSERT_SQL="insert into carlist values(?,(select cartype from car where cartype=?),?,"
												+ " (select carloc from location where carloc=?),y,0,0)";
	private static final String CAR_LIST_SQL="select carlist.carnum as carnum, carlist.validrent as validrent, car.carname as carname"
												+ " from car join carlist on car.cartype = carlist.cartype"
												+ " join location on carlist.carloc = location.carloc"
												+ " where location.carloc=? order by carlist.carnum";
	@Override
	public boolean insert(JoinInsert joininsert) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(CAR_INSERT_SQL);
			
			preparedStatement.setString(1, joininsert.getCarNum());
			preparedStatement.setInt(2, joininsert.getCarType());
			preparedStatement.setInt(3, joininsert.getCost());
			preparedStatement.setInt(4, joininsert.getCarloc());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}	
		return result;
	}
}
