package com.clps.utils;

import java.util.List;


/**
 * pageBean  用于数据的分页
 * @author bill
 * @date   2018年1月30日 下午3:19:09
 */
public class Pager {

	private int page;      //当前页
	private int size;      //条数
	private int totalpage; //总页数
	private List list;     //数据集
	
	public Pager() {
		super();
	}

	public Pager(int page, int size, int totalpage, List list) {
		super();
		this.page = page;
		this.size = page;
		this.totalpage = totalpage;
		this.list = list;
	}
	
	

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Pager [page=" + page + ", size=" + size + ", totalpage="
				+ totalpage + ", list=" + list + "]";
	}
}
