package dao;

import model.CommList;

public interface CommListDAO {
	
	boolean insert(CommList commList);
	
	boolean update(CommList commmList);
	
	CommList selectByQuestnum(int questnum);

}
