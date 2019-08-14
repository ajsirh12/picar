package dao;

import model.PicarMember;

public interface PicarMemberDAO {

	boolean insert (PicarMember picarMember);
	
	PicarMember selectById(String id,String password);
}
