package co.kr.VO;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PagingMaker {

	private int totalData;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	private PageCriteria pCri;
	
	private void getPagingData() {
		endPage = (int)(Math.ceil(pCri.getPage()/(double)displayPageNum)*displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int finalEndPage = (int)(Math.ceil(totalData/(double)pCri.getNumPerPage()));

		if(endPage > finalEndPage) {
			endPage = finalEndPage;
		}
		
		prev = startPage == 1? false: true;
		next = endPage*pCri.getNumPerPage() >= totalData ? false : true;
		
		
	}
	
		public String makeUri(int page) {
			
			UriComponents uriComponent = UriComponentsBuilder.newInstance()
										.queryParam("page", page).queryParam("numPerPage", pCri.getNumPerPage()).build();
			
			return uriComponent.toString();
		}

	public int getTotalData() {
		return totalData;
	}

	public void setTotalData(int totalData) {
		this.totalData = totalData;
		getPagingData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public PageCriteria getpCri() {
		return pCri;
	}

	public void setpCri(PageCriteria pCri) {
		this.pCri = pCri;
	}
		
}
