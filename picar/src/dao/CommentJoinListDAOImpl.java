package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
