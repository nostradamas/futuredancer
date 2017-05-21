package com.fda.controller.res;

import java.util.List;

/**
 * 
 */
public class DataTablesResult<T> extends BaseResult{

	private List<T> data;//返回的数据
	private Integer draw;//请求中的draw然后再返回就可以
	private Integer recordsFiltered;//开启过滤的话 ，是过滤的条数，不开启就是和总记录数一样
	private Integer recordsTotal;//总记录数

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public Integer getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

}
