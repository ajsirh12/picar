package page;

public interface PageDAO {
	int getCount(String sql);
	int getCount(String sql, String str);
}
