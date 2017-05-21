package com.fdw.controller.res;

/**
 * 对象返回结果
 * 
 * @author cuihaidong
 *
 */
public class ObjectResult<T> extends BaseResult {

	private T data;// 对象数据

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
