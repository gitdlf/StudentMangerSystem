package cn.lfsenior.entity;

import java.util.List;

/**
 * 封装分页的参数
 * @author LFSenior
 *
 *下午4:13:13
 *
 */
public class PageBean<T> {//使用泛型
	private int currentPage=1;//当前页，默认显示第一页
	private int pageCount=8;//煤业显示的行数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private List<T> pageData;//分页查询到数据
	
	//返回总页数
	public int getTotalPage() {
		if(totalCount%pageCount==0){
			totalPage=totalCount/pageCount;
		}else{
			totalPage=totalCount/pageCount+1;
		}
		
		return totalPage;
	}
	public void setTotalPage(int totalPatge) {
		this.totalPage = totalPatge;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
}
