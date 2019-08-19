package dao;

import model.PicarMember;

public interface PicarMemberDAO {

	boolean insert (PicarMember picarMember);
	
	PicarMember selectById(String id,String password);
	
	int checkById(String id);
	
	PicarMember selectFindId(String name,String phone);
	
	PicarMember selectFindPassword(String id,String name,String phone);
	
	boolean update (PicarMember picarMember);
}
