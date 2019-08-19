package dao;

import java.util.List;

import model.Question;

public interface QuestionDAO1 {
	
	
	List<Question> selectAll();
/*	List<Question> selectAll(int rowStartNumber, int rowEndNumber);*/
	/*Question selectByQuestnum(int questnum);*/
	
	boolean insert(Question question);

}
