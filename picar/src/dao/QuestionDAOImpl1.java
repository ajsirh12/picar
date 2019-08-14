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
	
/*	private static final String QUESTION_INSERT_SQL*/
	
	private static final String QUESTION_SELECT_ALL_SQL
	="SELECT *"
			+ " FROM picarmember,question"
			+ " WHERE question.membernum = picarmember.membernum"
			+ " ORDER BY questnum DESC";
	private static final String QUESTION_SELECT_PAGE_ALL_SQL
	="SELECT *"
			+ " FROM (SELECT ROWNUM RN, questions.*"
			+ " FROM (SELECT * FROM QUESTION ORDER BY questnum DESC) questions)"
			+ " WHERE rn BETWEEN ? and ?";

	@Override
	public boolean insert(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Question question) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Question> selectAll() {
		
		List<Question> questions = new ArrayList<Question>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(QUESTION_SELECT_ALL_SQL);
			resultSet = preparedStatement.executeQuery();
			
		while (resultSet.next()) {
			Question question = new Question();
			PicarMember picarMember = new PicarMember();
			
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

	@Override
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
		}
}
