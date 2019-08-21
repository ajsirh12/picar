package page;

public class PageManager {
	private int requestPage;
	
	public PageManager() {
		
	}

	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();	//객체변수 값 세팅
		
		if(requestPage>0) {
			pageRowResult.setRowStartNumber((requestPage - 1) * PageInfo.ROW_COUNT_PRE_PAGE + 1);
			pageRowResult.setRowEndNumber(requestPage * PageInfo.ROW_COUNT_PRE_PAGE);
		}
		
		
		return pageRowResult;
	}
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		
		PageDAO pageDAO = new PageDAOImpl();
		int count = pageDAO.getCount(sql);
		int totalPageNumber = (int)Math.ceil((double)count/PageInfo.ROW_COUNT_PRE_PAGE);
		
		/*System.out.println(count);
		System.out.println(totalPageNumber);*/
		int requestPageGroupNumber = ((requestPage - 1) / PageInfo.SHOW_PAGE_COUNT) + 1;
		int lastPageGroupNumber = ((totalPageNumber - 1) / PageInfo.SHOW_PAGE_COUNT) + 1;
		System.out.println("q "+requestPageGroupNumber);
		pageGroupResult.setGroupStartNumber((requestPageGroupNumber-1) * PageInfo.SHOW_PAGE_COUNT + 1);
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber * PageInfo.SHOW_PAGE_COUNT);
		if(pageGroupResult.getGroupEndNumber()>totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);
		}
		
		if(requestPageGroupNumber == 1) {
			pageGroupResult.setBeforPage(false);
		}
		if(requestPageGroupNumber == lastPageGroupNumber) {
			pageGroupResult.setAfterPage(false);
		}
		if(requestPageGroupNumber != 1 && requestPageGroupNumber != lastPageGroupNumber) {
			pageGroupResult.setBeforPage(true);
			pageGroupResult.setAfterPage(true);
		}
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		return pageGroupResult;
	}
	public PageGroupResult getPageGroupResult(String sql, String str) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		
		PageDAO pageDAO = new PageDAOImpl();
		int count = pageDAO.getCount(sql, str);
		int totalPageNumber = (int)Math.ceil((double)count/PageInfo.ROW_COUNT_PRE_PAGE);
		
		/*System.out.println(count);
		System.out.println(totalPageNumber);*/
		int requestPageGroupNumber = ((requestPage - 1) / PageInfo.SHOW_PAGE_COUNT) + 1;
		int lastPageGroupNumber = ((totalPageNumber - 1) / PageInfo.SHOW_PAGE_COUNT) + 1;
		System.out.println("q "+requestPageGroupNumber);
		pageGroupResult.setGroupStartNumber((requestPageGroupNumber-1) * PageInfo.SHOW_PAGE_COUNT + 1);
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber * PageInfo.SHOW_PAGE_COUNT);
		if(pageGroupResult.getGroupEndNumber()>totalPageNumber) {
			pageGroupResult.setGroupEndNumber(totalPageNumber);
		}
		
		if(requestPageGroupNumber == 1) {
			pageGroupResult.setBeforPage(false);
		}
		if(requestPageGroupNumber == lastPageGroupNumber) {
			pageGroupResult.setAfterPage(false);
		}
		if(requestPageGroupNumber != 1 && requestPageGroupNumber != lastPageGroupNumber) {
			pageGroupResult.setBeforPage(true);
			pageGroupResult.setAfterPage(true);
		}
		
		pageGroupResult.setSelectPageNumber(requestPage);
		
		return pageGroupResult;
	}
	public static void main(String[] args) {
		/*PageManager manager = new PageManager(1);
		PageRowResult pageRowResult = manager.getPageRowResult();
		manager.getPageGroupResult();
		System.out.println(manager.getPageRowResult().getRowStartNumber());
		System.out.println(manager.getPageRowResult().getRowEndNumber());
		System.out.println(pageRowResult.getRowStartNumber());
		System.out.println(pageRowResult.getRowEndNumber());*/

	}
}
