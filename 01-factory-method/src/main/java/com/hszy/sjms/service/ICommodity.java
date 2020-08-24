package com.hszy.sjms.service;

import com.hszy.sjms.product.IProduct;

/**
 * 工厂接口
 * @author fei30
 *
 */
public interface ICommodity {

	Long getType();
	
	IProduct createCommodity();

}
