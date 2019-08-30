package page3;

public class PageManager {
	
	private int requestPage;
	
	public PageManager() {
		
	}


	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResullt() {
		PageRowResult pageRowResult = new PageRowResult();
		//PageRowResult의 객체변수 값 셋팅
		
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PAGE*(requestPage-1)+1);//1, 6
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PAGE*requestPage);//5, 10
		
		return pageRowResult;
	}
	
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult pageGropResult = new PageGroupResult();
		//PageGroupResult의 객체변수 값 셋팅
		int requestPageGroupNumber=(requestPage-1)/PageInfo.SHOW_PAGE_COUNT;
		//int requestPageGroupNumber=(int)math.ceil((double)requestPage/PageInfo.SHOW_PAGE_COUNT);
		
		
		System.out.println(requestPageGroupNumber);
		
		pageGropResult.setGroupStartNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT+1);
		pageGropResult.setGroupEndNumber((requestPageGroupNumber+1)*PageInfo.SHOW_PAGE_COUNT);
		
		//pageGropResult.setGroupStartNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT-(PageInfo.SHOW_PAGE_COUNT-1));
		//pageGropResult.setGroupEndNumber(requestPageGroupNumber*PageInfo.SHOW_PAGE_COUNT);
		
		//총줄수 가져오기
		PageDAO dao = new PageDAOImpl();
		int totalRow = dao.getCount(sql);
		
		//int totalPageNumber = 총줄수/한페이지에 보여주는 줄수;
		
		//총링크 개수
		int totalPageNumber = (totalRow-1)/PageInfo.ROW_COUNT_PAGE+1;
		//(int)meth.ceil((double)totalRow/PageInfo.ROW_COUNT_PAGE);
		
		//last 페이지 링크값 변경
		if(pageGropResult.getGroupEndNumber() > totalPageNumber) {
			pageGropResult.setGroupEndNumber(totalPageNumber);
		}
		
		//befor, after 
		if(pageGropResult.getGroupStartNumber()==1) {
			pageGropResult.setBeforPage(false);
			
		}
		if(pageGropResult.getGroupEndNumber()==totalPageNumber) {
			pageGropResult.setAfterPage(false);
			
		}
		
		pageGropResult.setSelectPageNumber(requestPage);
		
		return pageGropResult;
	}
	
	public static void main(String[] args) {
		
		PageManager pm = new PageManager(1);
		
		System.out.println(pm.getPageRowResullt().getRowStartNumber());
		System.out.println(pm.getPageRowResullt().getRowEndNumber());
		
		
	}

}
