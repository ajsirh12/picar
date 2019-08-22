package dao;

import java.util.List;

import model.JoinRent;

public interface JoinDAO {
	List<JoinRent> selectJoin();
	List<JoinRent> selectJoinBycarNum(String carNum);
	List<JoinRent> selectJoin(int rowStartNumber, int rowEndNumber);
	List<JoinRent> selectJoinBycarNum(int rowStartNumber, int rowEndNumber,String carNum);
	JoinRent selectReturn(String carNum);
}
