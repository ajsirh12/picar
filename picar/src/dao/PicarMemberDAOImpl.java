package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PicarMember;

public class PicarMemberDAOImpl extends BaseDAO implements PicarMemberDAO {

	private static final String PICARMEMBER_INSERT_SQL
	="insert into picarmember VALUES(SEQ_MEMBERNUM.nextval,?,?,?,?,?,?,10)";
	
	private static final String PICARMEMBER_SELECT_BY_ID_SQL
	="SELECT * FROM picarmember WHERE id=? and password=?";
	
	private static final String PICARMEMBER_SELECT_ALL_SQL
	="SELECT *"
			+ " FROM picarmember"
			+ " ORDER BY membernum";
	
	private static final String PICARMEMBER_CHECK_BY_ID_SQL
	="SELECT COUNT(*) AS cnt FROM picarmember WHERE id=?";
	
	//회원가입
	@Override
	public boolean insert(PicarMember picarMember) {

		boolean result = false;
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection=getConnection();
			preparedStatement =connection.prepareStatement(PICARMEMBER_INSERT_SQL);
			
			preparedStatement.setString(1, picarMember.getId());
			preparedStatement.setString(2, picarMember.getPassword());
			preparedStatement.setString(3, picarMember.getName());
			preparedStatement.setString(4, picarMember.getPhone());
			preparedStatement.setInt(5,picarMember.getLicense());
			preparedStatement.setString(6, picarMember.getValidate());			
							
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
				result = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(null, preparedStatement, connection);
		}

		return result;
	}
	
	//로그인

	@Override
	public PicarMember selectById(String id, String password) {
		
		PicarMember picarMember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = getConnection();
			preparedStatement =connection.prepareStatement(PICARMEMBER_SELECT_BY_ID_SQL);
			preparedStatement.setString(1,id);
			preparedStatement.setString(2,password);
			resultSet = preparedStatement.executeQuery();
			
			 if(resultSet.next()) {
				 
				picarMember = new PicarMember();
								
				picarMember.setMemberNum(resultSet.getInt("membernum"));
				picarMember.setId(resultSet.getString("id"));
				picarMember.setPassword(resultSet.getString("password"));
				picarMember.setName(resultSet.getString("name"));
				picarMember.setPhone(resultSet.getString("phone"));
				picarMember.setLicense(resultSet.getInt("license"));
				picarMember.setValidate(resultSet.getString("validdate"));
				picarMember.setGradeNo(resultSet.getInt("gradeno"));
	
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return picarMember;		
	}

	@Override
	public List<PicarMember> selectAll() {
		
		List<PicarMember> picarMembers = new ArrayList<PicarMember>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			
		while(resultSet.next()) {
			PicarMember picarMember = new PicarMember();
			
			picarMember.setMemberNum(resultSet.getInt("memberNum"));
			picarMember.setId(resultSet.getString("id"));
			picarMember.setPassword(resultSet.getString("password"));
			picarMember.setName(resultSet.getString("name"));
			picarMember.setPassword(resultSet.getString("phone"));
			picarMember.setLicense(resultSet.getInt("license"));
			picarMember.setValidate(resultSet.getString("validdate"));
			picarMember.setGradeNo(resultSet.getInt("gradeNo"));
			
			picarMembers.add(picarMember);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return picarMembers;
	}

	@Override
	public int checkById(String id) {
		// TODO Auto-generated method stub
		return 0;
	} 
	
}
