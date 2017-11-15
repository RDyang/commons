package com.rdyang.hibernate.util;

import java.util.List;

public class Pagination<T> {
	private long rowsCount;
	private int curCount;
	private int pageSize;
	private int pageIndex;
	private int pageCount;
	private List<T> items;

	public Pagination() {

	}

	public Pagination(long rowsCount, int pageIndex, int pageSize, int curCount,
			List<T> items) {
		super();
		this.rowsCount = rowsCount;
		this.curCount = curCount;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.pageCount = (int) ((rowsCount % pageSize) > 0
				? rowsCount / pageSize + 1
				: rowsCount / pageSize);
		this.items = items;
	}

	public int getCurCount() {
		return curCount;
	}

	public void setCurCount(int curCount) {
		this.curCount = curCount;
	}

	public long getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(long rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Pagination [rowsCount=" + rowsCount + ", curCount=" + curCount
				+ ", pageSize=" + pageSize + ", pageIndex=" + pageIndex
				+ ", pageCount=" + pageCount + ", items=" + items + "]";
	}

}
