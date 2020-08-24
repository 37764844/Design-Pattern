package com.hszy.sjms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hszy.sjms.product.IProduct;
import com.hszy.sjms.service.ICommodity;

@RestController
public class FactoryMethodController {

	@Autowired
	private List<ICommodity> iCommodityList;
	
	@PostMapping("awardToUser")
	public void awardToUser(String uId, Long awardType) throws Exception {
		if(null == awardType) {
			return ;
		}
		for (ICommodity iCommodity : iCommodityList) {
			if(iCommodity.getType().equals(awardType)) {
				IProduct product =  iCommodity.createCommodity();
				product.sendProduct(uId);
			}
		}
		throw new RuntimeException("不存在的商品服务类型");
	}
}
