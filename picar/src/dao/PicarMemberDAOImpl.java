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
	="insert into picarmember VALUES(SEQ_MEMBERNUM.nextval,?,?,?,?,?,?,10,'Y')";
	
	private static final String PICARMEMBER_SELECT_BY_ID_SQL
	="SELECT MEMBERNUM,ID,PASSWORD,NAME,PHONE,LICENSE,to_char(validdate,'yyyy-mm-dd')VALIDDATE,GRADENO,RENTED FROM picarmember WHERE id=? and password=?";
	
	private static final String PICARMEMBER_SELECT_ALL_SQL
	="SELECT membernum,id,password,name,phone,license,to_char(validdate,'yyyy-mm-dd')validdate,MEMBERGRADE,membergrade.gradeno FROM picarmember ,membergrade where picarmember.gradeno = membergrade.gradeno ORDER BY membernum";
	
	private static final String PICARMEMBER_SELECT_ALL_PASING_SQL
	="SELECT * FROM (SELECT ROWNUM RN, members.* FROM (SELECT membernum as , id,password, name, phone, license, to_char(validdate,'yyyy-mm-dd')validdate,MEMBERGRADE,membergrade.gradeno as gradeno FROM picarmember,MEMBERGRADE WHERE picarmember.gradeno = membergrade.gradeno order by membernum desc) members) WHERE rn BETWEEN ? and ?";
	
	private static final String PICARMEMBER_CHECK_BY_ID_SQL
	="SELECT COUNT(*) AS cnt FROM picarmember WHERE id=?"; 
	
	private static final String PICARMEMBER_FIND_ID_SQL
	="SELECT * FROM picarmember WHERE name=? AND phone=?";
	
	private static final String PICARMEMBER_FIND_PASSWORD_SQL
	="select * from picarmember where id=? and name=? AND phone=?";
	
	private static final String PICARMEMBER_PASSWORD_CHANGE_SQL
	="update picarmember set password=? WHERE id=? AND NAME=? AND PHONE=?";
	
	private static final String PICARMEMBER_SELECT_MEMBERNUM_SQL
	="SELECT membernum,id,password,name,phone,license,to_char(validdate,'yyyy-mm-dd')validdate ,MEMBERGRADE,membergrade.gradeno FROM picarmember ,membergrade where picarmember.gradeno = membergrade.gradeno and picarmember.membernum =?";
	
	private static final String PICARMEMBER_UPDATE_SQL
	="update picarmember set id=?, password=?,name=?, phone=?,LICENSE=?,validdate=?,gradeno=? where membernum=?";
	
	private static final String PICARMEMBER_DELETE_SQL
	="delete from picarmember where membernum=?";
	
	private static final String PICARMEMBER_INFOR_UPDATE_SQL
	="UPDATE picarmember SET PASSWORD=?, NAME=?, PHONE=?, LICENSE=?, VALIDDATE=? WHERE membernum=?";
	
	private static final String PICAEMEMBER_CHECK_PASSWORD_SQL
	="SELECT COUNT(*) AS cntt FROM picarmember WHERE PASSWORD=?";
	
	private static final String PICARMEMBER_UPDATE_TO_Y
	="UPDATE picarmember SET rented = 'Y' WHERE membernum=?";
	
	private static final String PICARMEMBER_UPDATE_TO_N
	="UPDATE picarmember SET rented = 'N' WHERE membernum=?";
	
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
			preparedStatement.setString(5,picarMember.getLicense());
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
				picarMember.setLicense(resultSet.getString("license"));
				picarMember.setValidate(resultSet.getString("validdate"));
				picarMember.setGradeNo(resultSet.getInt("gradeno"));
				picarMember.setRented(resultSet.getString("rented"));
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return picarMember;		
	}

	//회원리스트
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
			picarMember.setPhone(resultSet.getString("phone"));
			picarMember.setLicense(resultSet.getString("license"));
			picarMember.setValidate(resultSet.getString("validdate"));			
			picarMember.setGradeNo(resultSet.getInt("gradeNo"));
			picarMember.setMemberGrade(resultSet.getString("membergrade"));

			
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
	
	//아이디찾기
	@Override
	public PicarMember selectFindId(String name, String phone) {
		
		PicarMember picarMember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = getConnection();
			preparedStatement =connection.prepareStatement(PICARMEMBER_FIND_ID_SQL);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, phone);
			resultSet = preparedStatement.executeQuery();
			
			 if(resultSet.next()) {
				 
				picarMember = new PicarMember();
						
				picarMember.setName(resultSet.getString("name"));
				picarMember.setPhone(resultSet.getString("phone"));				
				picarMember.setId(resultSet.getString("id"));	
					
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		System.out.println(picarMember);
		return picarMember;		
	}

	//비밀번호 찾기
	@Override
	public PicarMember selectFindPassword(String id, String name, String phone) {
		
		PicarMember picarMember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = getConnection();
			preparedStatement =connection.prepareStatement(PICARMEMBER_FIND_PASSWORD_SQL);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3, phone);
			resultSet = preparedStatement.executeQuery();
			
			 if(resultSet.next()) {
				 
				picarMember = new PicarMember();
												
				picarMember.setId(resultSet.getString("id"));			
				picarMember.setName(resultSet.getString("name"));
				picarMember.setPhone(resultSet.getString("phone"));
				picarMember.setPassword(resultSet.getString("password"));
									
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		
		return picarMember;
	}

	//비밀번호 변경
	@Override
	public boolean update(PicarMember picarMember) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_PASSWORD_CHANGE_SQL);
			preparedStatement.setString(1, picarMember.getPassword());
			preparedStatement.setString(2, picarMember.getId());
			preparedStatement.setString(3, picarMember.getName());
			preparedStatement.setString(4, picarMember.getPhone());
		
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

	//아이디중복체크
	@Override
	public int checkById(String id) {
		int count = 1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_CHECK_BY_ID_SQL);
			preparedStatement.setString(1, id);
			
			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				count = resultSet.getInt("cnt");
				System.out.println(count);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	//관리자 회원 디테일
	@Override
	public PicarMember selectByNum(int membernum) {
		
		PicarMember picarmember = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			connection = getConnection();
			preparedStatement =connection.prepareStatement(PICARMEMBER_SELECT_MEMBERNUM_SQL);
			preparedStatement.setInt(1,membernum);
			resultSet = preparedStatement.executeQuery();
			
			 if(resultSet.next()) {
				picarmember = new PicarMember();
				picarmember.setMemberNum(resultSet.getInt("membernum"));
				picarmember.setId(resultSet.getNString("id"));
				picarmember.setPassword(resultSet.getString("password"));
				picarmember.setName(resultSet.getString("name"));
				picarmember.setPhone(resultSet.getString("phone"));
				picarmember.setLicense(resultSet.getString("license"));
				picarmember.setValidate(resultSet.getString("validdate"));
				picarmember.setMemberGrade(resultSet.getString("membergrade"));
				picarmember.setGradeNo(resultSet.getInt("gradeno"));
				 							
			}
						
		} catch (SQLException e) {			
			e.printStackTrace();			
		}finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
					
		return picarmember;
	}

	//관리자가 회원정보 수정
	@Override
	public boolean memberUpdate(PicarMember picarMember) {
		boolean result = false;
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_UPDATE_SQL);
								
			preparedStatement.setString(1, picarMember.getId());
			preparedStatement.setString(2, picarMember.getPassword());	
			preparedStatement.setString(3, picarMember.getName());
			preparedStatement.setString(4, picarMember.getPhone());		
			preparedStatement.setString(5, picarMember.getLicense());
			preparedStatement.setString(6, picarMember.getValidate());
			preparedStatement.setInt(7, picarMember.getGradeNo());
			preparedStatement.setInt(8, picarMember.getMemberNum());
										
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
		
	//관리자가 회원정보 삭제 
	@Override
	public boolean deleteByMemberNum(int membernum) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;		
	
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_DELETE_SQL);

			preparedStatement.setInt(1, membernum);
			
			int rowCount=preparedStatement.executeUpdate();
			
			if(rowCount>0) {
	            result=true;
	         }
						
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			closeDBObjects(null, preparedStatement, connection);				
		}
		return result;
	}
	
	//회원이 정보 수정
	@Override
	public boolean memberInforUpdate(PicarMember picarMember) {
		boolean result = false;
		
		Connection connection =null;
		PreparedStatement preparedStatement =null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_INFOR_UPDATE_SQL);
			
			preparedStatement.setString(1, picarMember.getPassword());	
			preparedStatement.setString(2, picarMember.getName());
			preparedStatement.setString(3, picarMember.getPhone());		
			preparedStatement.setString(4, picarMember.getLicense());
			preparedStatement.setString(5, picarMember.getValidate());
			preparedStatement.setInt(6, picarMember.getMemberNum());
										
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

	//비밀번호 확인
	@Override                     
	public int checkBypwd(String password) {
		int count = 1;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICAEMEMBER_CHECK_PASSWORD_SQL);
			preparedStatement.setString(1, password);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				count = resultSet.getInt("cntt");
				System.out.println(count+"//111");
			}
			System.out.println(count+"//2222");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(count);
		return count;
	}

	@Override
	public void updateRentedToY(int memberNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_UPDATE_TO_Y);
			preparedStatement.setInt(1, memberNum);
			preparedStatement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
	}

	@Override
	public void updateRentedToN(int memberNum) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_UPDATE_TO_N);
			preparedStatement.setInt(1, memberNum);
			preparedStatement.execute();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
	}
	
	//페이징
	@Override
	public List<PicarMember> selectListAll(int rowStartNumber, int rowEndNumber) {
		List<PicarMember> picarMembers = new ArrayList<PicarMember>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(PICARMEMBER_SELECT_ALL_PASING_SQL);
			preparedStatement.setInt(1,rowStartNumber);
			preparedStatement.setInt(2,rowEndNumber);
			resultSet = preparedStatement.executeQuery();
			
		while(resultSet.next()) {
			PicarMember picarMember = new PicarMember();
			
			picarMember.setMemberNum(resultSet.getInt("memberNum"));
			picarMember.setId(resultSet.getString("id"));
			picarMember.setPassword(resultSet.getString("password"));
			picarMember.setName(resultSet.getString("name"));
			picarMember.setPhone(resultSet.getString("phone"));
			picarMember.setLicense(resultSet.getString("license"));
			picarMember.setValidate(resultSet.getString("validdate"));			
			picarMember.setGradeNo(resultSet.getInt("gradeNo"));
			picarMember.setMemberGrade(resultSet.getString("membergrade"));

			
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


}