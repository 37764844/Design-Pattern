package com.hszy.sjms.product.impl;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟爱奇艺会员卡服务
 */
public class IQiYiCardService implements IProduct {

	public void sendProduct(String uId) {
		System.out.println("模拟发放爱奇艺会员卡一张：" + uId);
		
	}

}
