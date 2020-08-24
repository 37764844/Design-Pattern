package com.hszy.sjms.product.impl;

import com.hszy.sjms.product.IProduct;

/**
 * 模拟优惠券服务
 */
public class CouponService implements IProduct {

	public void sendProduct(String uId) {
		 System.out.println("模拟发放优惠券一张：" + uId);		
	}
}
