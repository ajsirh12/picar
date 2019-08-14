package dao;

import java.util.List;


import model.Question;

public interface QuestionDAO1 {
	
	
	List<Question> selectAll();
	List<Question> selectAll(int rowStartNumber, int rowEndNumber);
	
	boolean insert(Question question);
	boolean update(Question question);

}
