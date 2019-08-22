package util;

import java.util.List;

public class Page<T> {
	//总页数
	private int totalPageCount = 0;

	//页面大小
	private int pageSize=5;

	//总记录数
	private int totalCount;

	//当前页码
	private int currPageNo=1;

	//内容集合
	private List<T> list;

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount>0) {
			this.totalCount = totalCount;
			//计算总页数
			totalPageCount = totalCount%pageSize>0 ? totalCount/pageSize + 1  :  totalCount/pageSize ;
		}

	}

	public int getCurrPageNo() {
//		if (totalPageCount == 0) {
//			return 0;
//		}
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo>0) {
			this.currPageNo = currPageNo;
		}
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
