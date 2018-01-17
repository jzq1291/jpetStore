package com.clps.utils;

import java.util.List;
public class Pager {

	private int page;//当前页
	private int size;//条数
	private int totalpage;//总页数

	@SuppressWarnings("rawtypes")
	private List list;//列表
	
	public Pager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pager(int page, int size, int totalpage, List list) {
		super();
		this.page = page;
		this.size = size;
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

}
