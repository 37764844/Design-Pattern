package com.hszy.sjms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hszy.sjms.request.AwardReq;
import com.hszy.sjms.response.AwardRes;
import com.hszy.sjms.service.ICommodity;

@RestController
public class FactoryMethodController {

	@Autowired
	private List<ICommodity> iCommodityList;
	
	@PostMapping("awardToUser")
	public AwardRes awardToUser(AwardReq req) throws Exception {
		if(null == req.getAwardType()) {
			return null;
		}
		for (ICommodity iCommodity : iCommodityList) {
			if(iCommodity.getType().equals(req.getAwardType())) {
				return iCommodity.sendCommodity(req.getUId(), req.getAwardNumber(),req.getBizId(), req.getExtMap());
			}
		}
		throw new RuntimeException("不存在的商品服务类型");
	}
}
