package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PicarMember;
import model.Question;

public class QuestionDAOImpl1 extends BaseDAO implements QuestionDAO1{
	
	private static final String QUESTION_INSERT_SQL
	="INSERT INTO question"
			+ " VALUES(SEQ_QUESTNUM.nextval,?,?,SYSDATE,?,?)";
	
	private static final String QUESTION_SELECT_ALL_A_SQL
	="SELECT *"
			+ " FROM question"
			+ " ORDER BY questnum DESC";
	
	private	static final String QUESTION_SELECT_BY_QUESTNNUM_SQL
	="SELECT *"
			+ " FROM QUESTION"
			+ " WHERE QUESTNUM=?";
	
/*	private static final String QUESTION_SELECT_PAGE_ALL_SQL
	="SELECT *"
			+ " FROM (SELECT ROWNUM RN, questions.*"
			+ " FROM (SELECT question.questnum as questnum, question.questtitle as questtitle, question.questtext as questtext, picarmember.membernum as membernum, picarmember.id as id, question.answer as answer, question.questdate as questdate"
			+ " FROM picarmember,question"
			+ " WHERE picarmember.membernum = question.membernum order by questnum desc) questions)"
			+ " WHERE rn BETWEEN ? and ?";*/

	@Override
	public boolean insert(Question question) {
		
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QUESTION_INSERT_SQL);
			
			preparedStatement.setString(1, question.getQuestTitle());
			preparedStatement.setString(2, question.getQuestText());
			preparedStatement.setString(3, "N");
			preparedStatement.setInt(4, question.getMemberNum());
			
			int rowCount = preparedStatement.executeUpdate();
			
			if(rowCount>0) {
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
	public List<Question> selectAll() {
		
		List<Question> questions = new ArrayList<Question>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QUESTION_SELECT_ALL_A_SQL);
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			Question question = new Question();
			
			question.setQuestnum(resultSet.getInt("questnum"));
			question.setQuestTitle(resultSet.getString("questTitle"));
			question.setQuestText(resultSet.getString("questText"));
			question.setQuestDate(resultSet.getString("questDate"));
			question.setAnswer(resultSet.getString("answer"));
			question.setMemberNum(resultSet.getInt("memberNum"));
			
			questions.add(question);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return questions;
	}

	/*@Override
	public Question selectByQuestnum(int questnum) {
		
		Question question = new Question();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QUESTION_SELECT_BY_QUESTNNUM_SQL);
			preparedStatement.setInt(1, questnum);
			
			resultSet = preparedStatement.executeQuery();
			
		if(resultSet.next()) {
			
			question.setQuestnum(resultSet.getInt("questnum"));
			question.setQuestTitle(resultSet.getString("questTitle"));
			question.setQuestText(resultSet.getString("questText"));
			question.setQuestDate(resultSet.getString("questDate"));
			question.setAnswer(resultSet.getString("answer"));
			question.setMemberNum(resultSet.getInt("memberNum"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return question;
	}*/

/*	@Override
	public List<Question> selectAll(int rowStartNumber, int rowEndNumber) {
		
		List<Question> questions = new ArrayList<Question>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QUESTION_SELECT_PAGE_ALL_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			
			Question question = new Question();
				
			question.setQuestnum(resultSet.getInt("questnum"));
			question.setQuestTitle(resultSet.getString("questTitle"));
			question.setQuestText(resultSet.getString("questText"));
			question.setQuestDate(resultSet.getString("questDate"));
			question.setAnswer(resultSet.getString("answer"));
			question.setMemberNum(resultSet.getInt("memberNum"));
			
				
			questions.add(question);	
			}
	    }
	 	catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return questions;
		}*/
}
