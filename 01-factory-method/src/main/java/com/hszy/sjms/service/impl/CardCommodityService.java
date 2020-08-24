package com.hszy.sjms.service.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;
import com.hszy.sjms.product.impl.IQiYiCardService;
import com.hszy.sjms.service.ICommodity;

/**
 * 爱奇艺兑换卡工厂
 * @author fei30
 *
 */
@Service
public class CardCommodityService implements ICommodity {

	@Override
	public Long getType() {
		return 3L;
	}

	@Override
	public IProduct createCommodity() {		
		return new IQiYiCardService();
	}
}
