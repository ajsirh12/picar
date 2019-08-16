package dao;

import java.util.List;

import model.PicarMember;

public interface PicarMemberDAO {

	boolean insert (PicarMember picarMember);
	List<PicarMember> selectAll();
	
	PicarMember selectById(String id,String password);
	
	int checkById(String id);
	
	
}
