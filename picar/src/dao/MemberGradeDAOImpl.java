package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MemberGrade;

public class MemberGradeDAOImpl extends BaseDAO implements MemberGradeDAO {

	private static final String MEMBERGRADE_SELECT_ALL
	="select * from membergrade";
	
	@Override
	public List<MemberGrade> gradeSelectAll() {
		List<MemberGrade> membergrades = new ArrayList<MemberGrade>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMBERGRADE_SELECT_ALL);
			resultSet = preparedStatement.executeQuery();
			
		while(resultSet.next()) {
			MemberGrade membergrade = new MemberGrade();
			
			membergrade.setGradeNo(resultSet.getInt("gradeno"));
			membergrade.setMemberGrade(resultSet.getString("membergrade"));
			
			
			membergrades.add(membergrade);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return membergrades;
	}

}
