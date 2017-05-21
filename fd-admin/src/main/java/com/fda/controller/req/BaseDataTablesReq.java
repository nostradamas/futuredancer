package com.fda.controller.req;

/**
 * DataTables 基本的请求参数
 */
public class BaseDataTablesReq extends ReqToken {

	private Integer draw;// 请求次数
	private Integer start; //数据的起始位置
	private Integer length; //长度
	private String sidx; // 默认降序
	private String sord;// 排序字段

	/**
	 * search[value] 搜索框中的值 
	 * order[i][column] 那一列排序 
	 * order[i][dir]排序方式
	 * columns[i][data]列的属性名 
	 * columns[i][name]列的名字 需要配置columns.name
	 * columns[i][searchable] 是否能搜索 
	 * columns[i][orderable] 是否排序
	 * columns[i][search][value]
	 * 
	 */

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

}
