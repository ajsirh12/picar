package page2;

public class PageSQL {
	
	public static final String COMMENTJOINLIST_SELECT_ALL_COUNT
	="SELECT COUNT(*) AS cnt"
			+ " FROM picarmember, question WHERE picarmember.membernum = question.membernum";
	
	
}
