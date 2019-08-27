package dao;
import model.JoinDetail;

public interface JoinDetailDAO {

	JoinDetail selectByCarNum(String carnum);
	
}
