package com.hszy.sjms.product.impl;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟实物商品服务
 */
public class GoodsService implements IProduct {

	public void sendProduct(String uId) {
		System.out.println("模拟发货实物商品一个：" + uId);		
	}
}
