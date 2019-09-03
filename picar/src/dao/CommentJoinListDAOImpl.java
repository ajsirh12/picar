package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import model.CommentJoinList;

public class CommentJoinListDAOImpl extends BaseDAO implements CommentJoinListDAO {
	
	private static final String COMMENTJOINLIST_SELECT_PAGE_ALL_SQL
	="SELECT *"
			+ " FROM (SELECT ROWNUM RN, questions.*"
			+ " FROM (SELECT question.questnum as questnum, question.questtitle as questtitle, question.questtext as questtext, picarmember.membernum as membernum, picarmember.id as id, question.answer as answer, question.questdate as questdate"
			+ " FROM picarmember,question"
			+ " WHERE picarmember.membernum = question.membernum order by questnum desc) questions)"
			+ " WHERE rn BETWEEN ? and ?";
	
	private static final String COMMENTJOINLIST_SELECT_BY_QUESTNNUM_SQL
	="SELECT *"
			+ " FROM question join PICARMEMBER on picarmember.membernum =question.membernum"
			+ " WHERE questnum=?";
	
	private static final String COMMENTJOINLIST_DELETE_BY_QUESTNNUM_SQL
	="DELETE FROM QUESTION"
			+ " WHERE QUESTNUM=?";
	
	private static final String COMMENTJOINLIST_UPDATE_SQL
	="UPDATE (SELECT * FROM QUESTION,PICARMEMBER WHERE question.membernum = picarmember.membernum)"
			+ " SET questtitle=?, questtext=?"
			+ " WHERE questnum=?";
	
	private static final String COMMENTJOINLIST_SELECT_PAGE_ALL_ADMIN_SQL
	="SELECT *"
			+ " FROM (SELECT ROWNUM RN, questions.*"
			+ " FROM (SELECT question.questnum as questnum, question.questtitle as questtitle, question.questtext as questtext, picarmember.membernum as membernum, picarmember.id as id, question.answer as answer, question.questdate as questdate"
			+ " FROM picarmember,question"
			+ " WHERE picarmember.membernum = question.membernum order by questnum desc) questions)"
			+ " WHERE rn BETWEEN ? and ?";
	
	private static final String COMMENTJOINLIST_UPDATE_ANSWER_SQL
	="UPDATE QUESTION"
			+ " SET ANSWER=?"
			+ " WHERE QUESTNUM =?";
	
	private static final String COMMENTJOINLIST_SELECT_BY_QUESTTITLE_SQL
	="SELECT *"
			+ " FROM question join PICARMEMBER on picarmember.membernum =question.membernum"
			+ " WHERE questtitle like ?"
			+ " ORDER BY QUESTNUM DESC";

	@Override
	public List<CommentJoinList> selectAll(int rowStartNumber, int rowEndNumber) {
		
		List<CommentJoinList> commentJoinLists = new ArrayList<CommentJoinList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMENTJOINLIST_SELECT_PAGE_ALL_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			
			CommentJoinList commentJoinList = new CommentJoinList();
				
			commentJoinList.setQuestnum(resultSet.getInt("questnum"));
			commentJoinList.setQuestTitle(resultSet.getString("questTitle"));
			commentJoinList.setQuestText(resultSet.getString("questText"));
			commentJoinList.setQuestDate(resultSet.getString("questDate"));
			commentJoinList.setAnswer(resultSet.getString("answer"));
			commentJoinList.setMemberNum(resultSet.getInt("memberNum"));
			commentJoinList.setId(resultSet.getString("id"));
			
				
			commentJoinLists.add(commentJoinList);	
			}
	    }
	 	catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return commentJoinLists;
		}

	@Override
	public CommentJoinList selectByQuestnum(int questnum) {
		
		CommentJoinList commentJoinList = new CommentJoinList();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMENTJOINLIST_SELECT_BY_QUESTNNUM_SQL);
			preparedStatement.setInt(1, questnum);
			
			resultSet = preparedStatement.executeQuery();
			
		if(resultSet.next()) {
			
			commentJoinList.setMemberNum(resultSet.getInt("memberNum"));
			commentJoinList.setId(resultSet.getString("id"));
			commentJoinList.setQuestnum(resultSet.getInt("questnum"));
			commentJoinList.setQuestTitle(resultSet.getString("questTitle"));
			commentJoinList.setQuestText(resultSet.getString("questText"));
			commentJoinList.setQuestDate(resultSet.getString("questDate"));
			commentJoinList.setAnswer(resultSet.getString("answer"));

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return commentJoinList;
	}

	@Override
	public boolean deleteByQuestnum(int questnum) {
		
			boolean result = false;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			
			try {
				connection = getConnection();
				preparedStatement = connection.prepareStatement(COMMENTJOINLIST_DELETE_BY_QUESTNNUM_SQL);
				preparedStatement.setInt(1, questnum);
				
				int rowCount = preparedStatement.executeUpdate();
				
				if(rowCount>0) {
					result=true;
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				closeDBObjects(null, preparedStatement, connection);
			}
			return result;
	}

	@Override
	public boolean update(CommentJoinList commentJoinList) {

		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement  = connection.prepareStatement(COMMENTJOINLIST_UPDATE_SQL);
			
			preparedStatement.setString(1, commentJoinList.getQuestTitle());
			preparedStatement.setString(2, commentJoinList.getQuestText());
			preparedStatement.setInt(3, commentJoinList.getQuestnum());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {System.out.println(result);
				result = true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public List<CommentJoinList> adminselectAll(int rowStartNumber, int rowEndNumber) {
		
		List<CommentJoinList> commentJoinLists = new ArrayList<CommentJoinList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMENTJOINLIST_SELECT_PAGE_ALL_ADMIN_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			
			CommentJoinList commentJoinList = new CommentJoinList();
				
			commentJoinList.setQuestnum(resultSet.getInt("questnum"));
			commentJoinList.setQuestTitle(resultSet.getString("questTitle"));
			commentJoinList.setQuestText(resultSet.getString("questText"));
			commentJoinList.setQuestDate(resultSet.getString("questDate"));
			commentJoinList.setAnswer(resultSet.getString("answer"));
			commentJoinList.setMemberNum(resultSet.getInt("memberNum"));
			commentJoinList.setId(resultSet.getString("id"));
			
				
			commentJoinLists.add(commentJoinList);	
			}
	    }
	 	catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return commentJoinLists;
		}

	@Override
	public boolean updateAnswer(int questnum) {
		
		boolean result1 = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMENTJOINLIST_UPDATE_ANSWER_SQL);
			
			preparedStatement.setString(1, "Y");
			preparedStatement.setInt(2, questnum);
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {System.out.println(result1);
				result1 = true;
			} 
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result1;
	}

	@Override
	public List<CommentJoinList> selectByTitle(String questTitle) {
		
		List<CommentJoinList> commentJoinLists = new ArrayList<CommentJoinList>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(COMMENTJOINLIST_SELECT_BY_QUESTTITLE_SQL);
			preparedStatement.setString(1, "%" + questTitle + "%");
			
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			
			CommentJoinList commentJoinList = new CommentJoinList();
			
			commentJoinList.setQuestnum(resultSet.getInt("questnum"));
			commentJoinList.setQuestTitle(resultSet.getString("questTitle"));
			commentJoinList.setQuestText(resultSet.getString("questText"));
			commentJoinList.setQuestDate(resultSet.getString("questDate"));
			commentJoinList.setAnswer(resultSet.getString("answer"));
			commentJoinList.setMemberNum(resultSet.getInt("memberNum"));
			commentJoinList.setId(resultSet.getString("id"));
			
				
			commentJoinLists.add(commentJoinList);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return commentJoinLists;
	}
}

