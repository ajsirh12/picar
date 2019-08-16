package dao;

import java.util.List;

import model.CommentJoinList;


public interface CommentJoinListDAO {
	
	List<CommentJoinList> selectAll(int rowStartNumber, int rowEndNumber);

}
