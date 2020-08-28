package com.hszy.sjms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;
import com.hszy.sjms.product.impl.CouponService;
import com.hszy.sjms.service.ICommodity;

/**
 * 优惠劵工厂
 * 
 * @author fei30
 *
 */
@Service
public class CouponCommodityService implements ICommodity {

	@Autowired
	CouponService couponService;
	
	@Override
	public Long getType() {
		return 1L;
	}

	@Override
	public IProduct createCommodity() {		
		return couponService;
	}
}
