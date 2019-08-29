package dao;

import model.RentInfo;

public interface RentInfoDAO {
	RentInfo selectByMemberNum(int memberNum);
	void renewByRentNum(int renew, int rentNum);
	void deleteByCarNum(String carNum);
	void insertRentInfo(RentInfo rentinfo);
	RentInfo selectByCarnum(String carNum);
}
