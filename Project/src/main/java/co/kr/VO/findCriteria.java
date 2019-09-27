package co.kr.VO;

public class findCriteria extends PageCriteria {

	private String findSome;
	private String searchType;
	
	
	public findCriteria(String findSome, String searchType) {
		this.findSome = findSome;
		this.searchType = searchType;
	}


	public String getFindSome() {
		return findSome;
	}


	public void setFindSome(String findSome) {
		this.findSome = findSome;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	
}
