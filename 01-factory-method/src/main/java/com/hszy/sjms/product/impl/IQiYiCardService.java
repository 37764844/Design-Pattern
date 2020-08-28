package com.hszy.sjms.product.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟爱奇艺会员卡服务
 */
@Service
public class IQiYiCardService implements IProduct {

	public void sendProduct(String uId) {
		System.out.println("模拟发放爱奇艺会员卡一张：" + uId);		
	}
}
