package com.hszy.sjms.product.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟优惠券服务
 */
@Service
public class CouponService implements IProduct {

	public void sendProduct(String uId) {
		 System.out.println("模拟发放优惠券一张：" + uId);		
	}
}
