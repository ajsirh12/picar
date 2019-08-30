package dao;

import java.util.List;

import model.PicarMember;

public interface PicarMemberDAO {

	boolean insert (PicarMember picarMember);
	
	List<PicarMember> selectAll();
	
	PicarMember selectById(String id,String password);
	
	PicarMember selectByNum(int membernum);
	
	int checkById(String id);
	
	PicarMember selectFindId(String name,String phone);
	
	PicarMember selectFindPassword(String id,String name,String phone);
	
	boolean update (PicarMember picarMember);
	
	boolean memberUpdate(PicarMember picarMember);
	
	boolean deleteByMemberNum(int membernum);		
	
	boolean memberInforUpdate(PicarMember picarMember);
	
	int checkBypwd(String password);
	
	void updateRentedToY(int memberNum);
	void updateRentedToN(int memberNum);
	
	List<PicarMember> selectListAll(int rowStartNumber, int rowEndNumber);	
}
