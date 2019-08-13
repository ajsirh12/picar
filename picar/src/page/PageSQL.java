package page;

public class PageSQL {
	public static final String RENTED_SELECT_ALL_COUNT = "SELECT count(*) FROM rentinfo, picarmember, carlist WHERE rentinfo.carnum = carlist.carnum and rentinfo.membernum = picarmember.membernum and carlist.validrent in ('n', 'N')";
	
}
