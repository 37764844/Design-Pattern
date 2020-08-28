package com.hszy.sjms.product.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟实物商品服务
 */
@Service
public class GoodsService implements IProduct {

	public void sendProduct(String uId) {
		System.out.println("模拟发货实物商品一个：" + uId);		
	}
}
