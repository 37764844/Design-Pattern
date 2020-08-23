package com.hszy.sjms.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.hszy.sjms.response.AwardRes;
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
	public AwardRes sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap)
			throws Exception {
		return null;
	}

}
