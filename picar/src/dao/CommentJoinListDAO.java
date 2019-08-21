package dao;

import java.util.List;


import model.CommentJoinList;


public interface CommentJoinListDAO {
	
	List<CommentJoinList> selectAll(int rowStartNumber, int rowEndNumber);
	
	List<CommentJoinList> adminselectAll(int rowStartNumber, int rowEndNumber);
	
	CommentJoinList selectByQuestnum(int questnum);
	
	boolean deleteByQuestnum(int questnum);
	boolean update(CommentJoinList commentJoinList);
	boolean updateAnswer(int questnum);
	
	

}
