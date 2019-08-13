package dao;

import java.util.List;

import model.JoinRent;

public interface JoinDAO {
	List<JoinRent> selectJoin();
	List<JoinRent> selectJoinBycarNum(String carNum);
	List<JoinRent> selectJoinPage(int rowStartNumber, int rowEndNumber);
}
