package com.hszy.sjms.service;

import java.util.Map;

import com.hszy.sjms.response.AwardRes;

/**
 * 工厂接口
 * @author fei30
 *
 */
public interface ICommodity {

	Long getType();
	
	AwardRes sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
