package com.hszy.sjms.service.impl;

import org.springframework.stereotype.Service;

import com.hszy.sjms.product.IProduct;
import com.hszy.sjms.product.impl.GoodsService;
import com.hszy.sjms.service.ICommodity;

/**
 * 实物商品工厂
 * 
 * @author fei30
 *
 */
@Service
public class GoodsCommodityService implements ICommodity {

	@Override
	public Long getType() {
		return 2L;
	}

	@Override
	public IProduct createCommodity() {
		return new GoodsService();
	}

}
